package br.com.aevc.pocswing.util;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;

public class ResourcesUtil {

    public static Iterator<URL> listResourcesFrom(String path) throws IOException {
        return Thread.currentThread()
                .getContextClassLoader()
                .getResources(path)
                .asIterator();
    }

    public static URL getResourceFrom(String path) {
        return Thread.currentThread()
                .getContextClassLoader()
                .getResource(path);
    }

}
