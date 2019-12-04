package ufc.gestao.scs.util.relatorios;

import java.awt.Color;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.text.DecimalFormat;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import ufc.gestao.scs.model.Cargo;

public class GenerateRelatorioCargosPdf {

    private static final Logger logger = LoggerFactory.getLogger(GenerateRelatorioCargosPdf.class);

    public static ByteArrayInputStream cargosReport(List<Cargo> cargos) {

        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {

            PdfPTable table = new PdfPTable(5);
            table.setWidthPercentage(100);

            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

            PdfPCell hcell;

            hcell = new PdfPCell(new Phrase("Titulação", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Área", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Unidade", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Salário Base Mínimo", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Salário Base Máximo", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            DecimalFormat formatter = new DecimalFormat("#,###.00");

            for (Cargo cargo : cargos) {

                PdfPCell cell;

                cell = new PdfPCell(new Phrase(cargo.getTitulacao()));
                cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell.setPaddingBottom(5);
                cell.setPaddingTop(5);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(cargo.getArea()));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setPaddingRight(5);
                cell.setPaddingBottom(5);
                cell.setPaddingTop(5);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(cargo.getUnidade()));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setPaddingRight(5);
                cell.setPaddingBottom(5);
                cell.setPaddingTop(5);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(formatter.format(cargo.getSalarioBaseMinimo()) + " R$"));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                cell.setPaddingRight(5);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(formatter.format(cargo.getSalarioBaseMaximo()) + " R$"));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                cell.setPaddingRight(5);
                table.addCell(cell);
            }

            PdfWriter.getInstance(document, out);
            document.open();

            // Create event-handlers

            Paragraph text = new Paragraph("Relatório - Lista de Cargos",
                    FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLD, new BaseColor(Color.BLACK.getRGB())));
            text.setAlignment(Element.ALIGN_CENTER);
            document.add(text);

            table.setSpacingBefore(20);

            document.add(table);

            document.close();

        } catch (DocumentException ex) {

            logger.error("Error occurred: {0}", ex);
        }

        return new ByteArrayInputStream(out.toByteArray());
    }

}