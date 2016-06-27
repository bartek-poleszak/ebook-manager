package com.example.bp.ebookmanager.model.formats;

/**
 * Ebook Manager
 * Created by bp on 07.05.16.
 */
public abstract class FormatSpecificData {
    public abstract String getFormatName();
    abstract void acceptVisitor(Visitor visitor);

    private Double sizeInMb = null;

    public void setSizeInMb(Double sizeInMb) {
        this.sizeInMb = sizeInMb;
    }

    public Double getSizeInMb() {
        return sizeInMb;
    }

    public static FormatSpecificData instanceForFormatName(String formatName) {
        FormatSpecificData result;
        switch (formatName) {
            case MobiDetails.FORMAT_NAME:
                result = new MobiDetails();
                break;
            case EpubDetails.FORMAT_NAME:
                result = new EpubDetails();
                break;
            case PdfDetails.FORMAT_NAME:
                result = new PdfDetails();
                break;
            case Mp3Details.FORMAT_NAME:
                result = new Mp3Details();
                break;
            default:
                throw new RuntimeException("Unexpected format name");
        }
        return result;
    }

    interface Visitor {
        void visitAudiobookSpecificData(AudiobookSpecificData data);
        void visitEbookSpecificData(EbookSpecificData data);
    }
}
