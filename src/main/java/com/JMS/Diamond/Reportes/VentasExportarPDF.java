package com.JMS.Diamond.Reportes;

import java.awt.Color;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.JMS.Diamond.modelo.Productos;
import com.JMS.Diamond.modelo.Reservas;
import com.JMS.Diamond.modelo.Ventas;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class VentasExportarPDF {


	private List<Ventas> listaVentas;

	public VentasExportarPDF(List<Ventas> listaVentas) {
		super();
		this.listaVentas = listaVentas;
	}
	
	

	private void escribirCabeceraDeLaTabla(PdfPTable tabla) {
		PdfPCell celda = new PdfPCell();

		celda.setBackgroundColor(Color.black);
		celda.setPadding(5);


		Font fuente = FontFactory.getFont(FontFactory.HELVETICA);
		fuente.setColor(Color.WHITE);



		celda.setPhrase(new Phrase("Cantidad", fuente));
		tabla.addCell(celda);

		celda.setPhrase(new Phrase("Fecha de la reserva ", fuente));
		tabla.addCell(celda);

		celda.setPhrase(new Phrase("Hora de Reserva", fuente));
		tabla.addCell(celda);

		celda.setPhrase(new Phrase("Valor total ", fuente));
		tabla.addCell(celda);

		celda.setPhrase(new Phrase("Dirección ", fuente));
		tabla.addCell(celda);

		celda.setPhrase(new Phrase("Nombre del producto ", fuente));
		tabla.addCell(celda);

	}

	private void escribirDatosDeLaTabla(PdfPTable tabla) {
		for (Ventas ventas : listaVentas) {
			tabla.addCell(String.valueOf(ventas.getCantidad()));
			tabla.addCell(ventas.getFechaVenta().toString());
			tabla.addCell(ventas.getHoraVenta());
			tabla.addCell(String.valueOf(ventas.getValorTotalVenta()));
			tabla.addCell(ventas.getDireccion());
			tabla.addCell(ventas.getNombre_producto());
	
		}
	}

	public void exportar(HttpServletResponse response) throws DocumentException, IOException {
		Document documento = new Document(PageSize.A4);
		PdfWriter.getInstance(documento, response.getOutputStream());

		documento.open();

		Font fuente = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		fuente.setColor(Color.black);
		fuente.setSize(18);

		Paragraph titulo = new Paragraph("Lista de empleados", fuente);
		titulo.setAlignment(Paragraph.ALIGN_CENTER);
		documento.add(titulo);

		PdfPTable tabla = new PdfPTable(6);
		tabla.setWidthPercentage(100);
		tabla.setSpacingBefore(15);
		tabla.setWidths(new float[] { 2.5f, 2.5f, 3f, 4f, 6f, 5f });
		tabla.setWidthPercentage(110);

		escribirCabeceraDeLaTabla(tabla);
		escribirDatosDeLaTabla(tabla);

		documento.add(tabla);
		documento.close();
	}
}
