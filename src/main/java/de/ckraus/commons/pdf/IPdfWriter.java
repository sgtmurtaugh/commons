package de.ckraus.commons.pdf;

import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.WriterProperties;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

@SuppressWarnings( { "unused", "javadoc" } )
public interface IPdfWriter {

    /**
     * getPdfWriter
     *
     * @param file
     *
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    default PdfWriter getPdfWriter( File file ) throws FileNotFoundException, IOException {

        PdfWriter writer = null;
        if ( null != file ) {
            writer = new PdfWriter( file );
        }
        return writer;
    }

    /**
     * getPdfWriter
     *
     * @param os
     *
     * @return
     * @throws IOException
     */
    default PdfWriter getPdfWriter( OutputStream os ) {

        PdfWriter writer = null;
        if ( null != os ) {
            writer = new PdfWriter( os );
        }
        return writer;
    }

    /**
     * getPdfWriter
     *
     * @param os
     * @param writerProperties
     *
     * @return
     * @throws IOException
     */
    default PdfWriter getPdfWriter( OutputStream os, WriterProperties writerProperties ) {

        PdfWriter writer = null;
        if ( null != os ) {
            writer = new PdfWriter( os, writerProperties );
        }
        return writer;
    }

    /**
     * getPdfWriter
     *
     * @param filename
     *
     * @return
     * @throws IOException
     */
    default PdfWriter getPdfWriter( String filename ) throws FileNotFoundException {

        PdfWriter writer = null;
        if ( StringUtils.isNotEmpty( filename ) ) {
            writer = new PdfWriter( filename );
        }
        return writer;
    }

    /**
     * getPdfWriter
     *
     * @param filename
     * @param writerProperties
     *
     * @return
     * @throws IOException
     */
    default PdfWriter getPdfWriter( String filename, WriterProperties writerProperties ) throws FileNotFoundException {

        PdfWriter writer = null;
        if ( StringUtils.isNotEmpty( filename ) ) {
            writer = new PdfWriter( filename, writerProperties );
        }
        return writer;
    }

}
