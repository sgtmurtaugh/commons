package de.ckraus.commons.pdf;

import com.itextpdf.forms.PdfAcroForm;
import com.itextpdf.kernel.pdf.PdfDocument;

/**
 * <p>All modify Methods <strong>must</strong> return three different modification states for consistent handling:
 * <ul>
 *     <li>true - succeeded</li>
 *     <li>false - failed</li>
 *     <li>null - omitted</li>
 * </ul>
 */
@SuppressWarnings({ "javadoc", "unused" })
public interface IPdfFieldModifier
    extends IPdfModifer {

    Boolean DEFAULT_CREATE_PDF_ACRO_FROM_IF_NOT_EXISTS = Boolean.FALSE;


    /**
     * isCreatePdfAcroFormIfNotExists
     * @return
     */
    default boolean isCreatePdfAcroFormIfNotExists() {
        return DEFAULT_CREATE_PDF_ACRO_FROM_IF_NOT_EXISTS;
    }

    /**
     * getPdfAcroForm
     * @param pdfDocument
     * @return
     * <p>Delegates to {@link #getPdfAcroForm(PdfDocument, boolean)} and uses {@link #isCreatePdfAcroFormIfNotExists()}
     * for the boolean param.</p>
     */
    default PdfAcroForm getPdfAcroForm(PdfDocument pdfDocument) {
        return this.getPdfAcroForm(
                pdfDocument,
                this.isCreatePdfAcroFormIfNotExists()
        );
    }

    /**
     * getPdfAcroForm
     * @param pdfDocument
     * @param bCreateIfNotExists
     * @return
     * <p>Delegates to {@link PdfAcroForm#getAcroForm(PdfDocument, boolean)} to get PdfAcroForm instance.</p>
     */
    default PdfAcroForm getPdfAcroForm(
            PdfDocument pdfDocument,
            boolean bCreateIfNotExists
    ) {
        PdfAcroForm pdfAcroForm = null;

        if (pdfDocument != null) {
            pdfAcroForm = PdfAcroForm.getAcroForm(
                    pdfDocument,
                    bCreateIfNotExists
            );
        }
        return pdfAcroForm;
    }

    /**
     * modify
     * @param pdfDocument
     * @return
     * <p>Determines the {@link PdfAcroForm} with the given {@link PdfDocument} and delegates to
     * {@link #modify(PdfAcroForm)}</p>
     */
    default Boolean modify(PdfDocument pdfDocument) {
        Boolean bModify = null;
        if (null != pdfDocument) {
            bModify = this.modify(
                    this.getPdfAcroForm(pdfDocument)
            );
        }
        return bModify;
    }

    /**
     * modify
     * @param pdfDocument
     * @param bCreateIfNotExists
     * @return
     * <p>Similar to {@link #modify(PdfAcroForm)} it determines the {@link PdfAcroForm} with the given
     * {@link PdfDocument} but delegates to {@link #modify(PdfDocument, boolean)}</p>
     */
    default Boolean modify(
            PdfDocument pdfDocument,
            boolean bCreateIfNotExists
    ) {

        Boolean bModify = null;
        if (null != pdfDocument) {
            bModify = this.modify(
                    this.getPdfAcroForm(
                            pdfDocument,
                            bCreateIfNotExists
                    )
            );
        }
        return bModify;
    }

    /**
     * modify
     * @param pdfAcroForm
     * @return
     * <p>This method must be implemented individually.</p>
     */
    Boolean modify(PdfAcroForm pdfAcroForm);

}
