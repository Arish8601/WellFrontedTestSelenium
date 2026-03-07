package com.Well.Engine;

import java.awt.AWTException;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.monte.media.Format;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.Registry;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;

import static org.monte.media.AudioFormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;

public class ScreenRecorderUtil extends ScreenRecorder {
    private static final Rational FRAME_RATE = Rational.valueOf(5);
    private static final Format fileFormat = new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI);
    private static final Format screenFormat = new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
            CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey, 24, FrameRateKey,
            FRAME_RATE, QualityKey, 0.8f, KeyFrameIntervalKey, 30 * 60);
    private static final Format mouseFormat = new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(30));
    private static final Format audioFormat = null;

    private static ScreenRecorderUtil screenRecorder;

    private final String name;

    public ScreenRecorderUtil(GraphicsConfiguration cfg, Rectangle captureArea, File movieFolder, String name)
            throws IOException, AWTException {
        super(cfg, captureArea, fileFormat, screenFormat, mouseFormat, audioFormat, movieFolder);
        this.name = name;
    }

    @Override
    protected File createMovieFile(Format fileFormat) throws IOException {
        File movieFolder = getMovieFolder();
        if (!movieFolder.exists()) {
            movieFolder.mkdirs();
        } else if (!movieFolder.isDirectory()) {
            throw new IOException("\"" + movieFolder + "\" is not a directory.");
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");
        return new File(movieFolder,
                name + "-" + dateFormat.format(new Date()) + "." + Registry.getInstance().getExtension(fileFormat));
    }

    public static void startRecord(String methodName) {
        try {
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            GraphicsDevice[] screens = ge.getScreenDevices();
            Rectangle captureSize = new Rectangle();
            for (GraphicsDevice screen : screens) {
                captureSize = captureSize.union(screen.getDefaultConfiguration().getBounds());
            }
            GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
            File file = new File("./test-recordings/");
            screenRecorder = new ScreenRecorderUtil(gc, captureSize, file, methodName);
            screenRecorder.start();
            BaseClass.recordingStarted = true;
        } catch (IOException | AWTException e) {
            e.printStackTrace();
        }
    }

    public static void stopRecord() {
        if (screenRecorder != null) {
            try {
                screenRecorder.stop();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private File getMovieFolder() {
        return new File("./test-recordings/");
    }
}
