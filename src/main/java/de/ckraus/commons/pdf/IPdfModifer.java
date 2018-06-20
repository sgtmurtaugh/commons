package de.ckraus.commons.pdf;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

/**
 * <p>All modify Methods <strong>must</strong> return three different modification states for consistent handling:
 * <ul>
 *     <li>true - succeeded</li>
 *     <li>false - failed</li>
 *     <li>null - omitted</li>
 * </ul>
 */
@SuppressWarnings({ "javadoc", "unused" })
public interface IPdfModifer
        extends IPdfReader, IPdfWriter {

    /**
     * getPdfDocument
     * @param pdfWriter
     * @return
     */
    default PdfDocument getPdfDocument( PdfWriter pdfWriter ) {
        PdfDocument pdfDocument = null;
        if (null != pdfWriter) {
            pdfDocument = new PdfDocument( pdfWriter );
        }
        return pdfDocument;
    }

    /**
     * getPdfDocument
     * @param pdfReader
     * @param pdfWriter
     * @return
     */
    default PdfDocument getPdfDocument(
            PdfReader pdfReader,
            PdfWriter pdfWriter
    ) {
        PdfDocument pdfDocument = null;
        if (null != pdfReader
                && null != pdfWriter) {

            pdfDocument = new PdfDocument(
                    pdfReader,
                    pdfWriter
            );
        }
        return pdfDocument;
    }

    /**
     * modify
     * @param src
     * @param dest
     * @return
     */
    default PdfDocument getPdfDocument(
            String src,
            String dest
    ) {
        PdfDocument pdfDocument = null;
        if (StringUtils.isNotEmpty(src)
                && StringUtils.isNotEmpty(dest)) {

            try {
                pdfDocument = this.getPdfDocument(
                        new PdfReader(src),
                        new PdfWriter(dest)
                );
            }
            catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        return pdfDocument;
    }

    /**
     * modify
     * @param pdfDocument
     * @return
     * <p>Returns three different modification states:
     * <ul>
     *     <li>true - succeeded</li>
     *     <li>false - failed</li>
     *     <li>null - omitted</li>
     * </ul>
     */
    Boolean modify(PdfDocument pdfDocument);

}
