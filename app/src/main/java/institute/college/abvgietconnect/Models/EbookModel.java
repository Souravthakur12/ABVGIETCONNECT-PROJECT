package institute.college.abvgietconnect.Models;

public class EbookModel {
    private String pdftitle, pdfurl;

    public EbookModel() {
    }

    public EbookModel(String pdftitle, String pdfurl) {
        this.pdftitle = pdftitle;
        this.pdfurl = pdfurl;
    }

    public String getPdftitle() {
        return pdftitle;
    }

    public void setPdftitle(String pdftitle) {
        this.pdftitle = pdftitle;
    }

    public String getPdfurl() {
        return pdfurl;
    }

    public void setPdfurl(String pdfurl) {
        this.pdfurl = pdfurl;
    }
}