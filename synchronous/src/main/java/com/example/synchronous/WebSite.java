package com.example.synchronous;

import java.util.Random;

public class WebSite implements Runnable {

    private final String webSiteName;
    private final WebBrowser webBrowser;

    public WebSite(final String webSiteName, final WebBrowser webBrowser) {
        this.webSiteName = webSiteName;
        this.webBrowser = webBrowser;
    }

    @Override
    public void run() {
        synchronized (this) {
            while (webBrowser.hasSpace()) {
                try {
                    Thread.sleep(new Random().nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                webBrowser.createNewTab(webSiteName);
            }
        }
    }
}
