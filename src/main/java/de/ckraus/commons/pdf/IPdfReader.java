package de.ckraus.commons.pdf;

import com.itextpdf.io.source.IRandomAccessSource;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.ReaderProperties;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

@SuppressWarnings({ "javadoc", "unused" })
public interface IPdfReader {

    /**
     * getPdfReader
     * @param file
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    default PdfReader getPdfReader(File file)
        throws FileNotFoundException, IOException {

        PdfReader reader = null;
        if (null != file) {
            reader = new PdfReader(file);
        }
        return reader;
    }

    /**
     * getPdfReader
     * @param is
     * @return
     * @throws IOException
     */
    default PdfReader getPdfReader(InputStream is)
        throws IOException {

        PdfReader reader = null;
        if (null != is) {
            reader = new PdfReader(is);
        }
        return reader;
    }

    /**
     * getPdfReader
     * @param is
     * @param readerProperties
     * @return
     * @throws IOException
     */
    default PdfReader getPdfReader(
            InputStream is,
            ReaderProperties readerProperties
    ) throws IOException {

        PdfReader reader = null;
        if (null != is) {
            reader = new PdfReader(
                    is,
                    readerProperties
            );
        }
        return reader;
    }

    /**
     * getPdfReader
     * @param randomAccessSource
     * @param readerProperties
     * @return
     * @throws IOException
     */
    default PdfReader getPdfReader(
            IRandomAccessSource randomAccessSource,
            ReaderProperties readerProperties
    ) throws IOException {

        PdfReader reader = null;
        if (null != randomAccessSource) {
            reader = new PdfReader(
                    randomAccessSource,
                    readerProperties
            );
        }
        return reader;
    }

    /**
     * getPdfReader
     * @param filename
     * @return
     * @throws IOException
     */
    default PdfReader getPdfReader( String filename ) throws IOException {
        PdfReader reader = null;
        if (StringUtils.isNotEmpty(filename)) {
            reader = new PdfReader(filename);
        }
        return reader;
    }

    /**
     * getPdfReader
     * @param filename
     * @param readerProperties
     * @return
     * @throws IOException
     */
    default PdfReader getPdfReader(
            String filename,
            ReaderProperties readerProperties
    ) throws IOException {

        PdfReader reader = null;
        if (StringUtils.isNotEmpty(filename)) {
            reader = new PdfReader(
                    filename,
                    readerProperties
            );
        }
        return reader;
    }

}
