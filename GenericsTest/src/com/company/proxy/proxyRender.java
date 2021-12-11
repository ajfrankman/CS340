package com.company.proxy;

import java.awt.*;



public class ImageRendererImplementation {

    protected Image render(String filename) {
        // Assume this method contains the necessary code to
        // read the specified file and return an image object
        // from the file's contents.
        return someImage;
    }
}

public class proxyRender {
    ImageRendererImplementation imageRendererImplementation;

    public proxyRender(ImageRendererImplementation imageRendererImplementation) {
        this.imageRendererImplementation = null;
    }


    public Image getImage(String fileName) {
        if (this.imageRendererImplementation == null) {
            imageRendererImplementation = new ImageRendererImplementation();
        }
        imageRendererImplementation.render(fileName);
        return someImage;
    }
}
