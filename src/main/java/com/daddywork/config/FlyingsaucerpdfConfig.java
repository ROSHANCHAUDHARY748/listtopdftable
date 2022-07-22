package com.daddywork.config;

import org.xhtmlrenderer.layout.SharedContext;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.ByteArrayOutputStream;

public class FlyingsaucerpdfConfig {

    public ByteArrayOutputStream convertHTMLtoPDF(String data) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ITextRenderer renderer = new ITextRenderer();
        SharedContext sharedContext = renderer.getSharedContext();
        sharedContext.setPrint(true);
        sharedContext.setInteractive(false);
        renderer.setDocumentFromString(data);
        renderer.layout();
        renderer.createPDF(bos, false);
        renderer.finishPDF();
        return bos;
    }

}
