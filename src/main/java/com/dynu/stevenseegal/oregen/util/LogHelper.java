package com.dynu.stevenseegal.oregen.util;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

public class LogHelper
{
    public static Logger logger;
    private static boolean debug = false;

    private static void log(Level level, Object object)
    {
        logger.log(level, String.valueOf(object));
    }

    public static void info(Object object)
    {
        log(Level.INFO, object);
    }

    public static void warn(Object object)
    {
        log(Level.WARN, object);
    }

    public static void error(Object object)
    {
        log(Level.ERROR, object);
    }

    private static void logDebug(Level level, Object object)
    {
        logger.log(level, "[DEBUG] " + String.valueOf(object));
    }

    public static void debug(Object object)
    {
        if (debug)
        {
            logDebug(Level.INFO, object);
        }
    }
}
