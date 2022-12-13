package com.JMS.Diamond.Reportes;

import java.awt.Color;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.JMS.Diamond.modelo.Productos;
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

public class ProductosExportarPDF {


	private List<Productos> listaProductos;

	public ProductosExportarPDF(List<Productos> listaProductos) {
		super();
		this.listaProductos = listaProductos;
	}
	
	

	private void escribirCabeceraDeLaTabla(PdfPTable tabla) {
		PdfPCell celda = new PdfPCell();

		celda.setBackgroundColor(Color.black);
		celda.setPadding(5);


		Font fuente = FontFactory.getFont(FontFactory.HELVETICA);
		fuente.setColor(Color.WHITE);



		celda.setPhrase(new Phrase("Fecha", fuente));
		tabla.addCell(celda);

		celda.setPhrase(new Phrase("nombre ", fuente));
		tabla.addCell(celda);

		celda.setPhrase(new Phrase("descripcion", fuente));
		tabla.addCell(celda);

		celda.setPhrase(new Phrase("Precio ", fuente));
		tabla.addCell(celda);

		celda.setPhrase(new Phrase("cantidad ", fuente));
		tabla.addCell(celda);

		celda.setPhrase(new Phrase("fecha Vencimiento ", fuente));
		tabla.addCell(celda);

	}

	private void escribirDatosDeLaTabla(PdfPTable tabla) {
		for (Productos productos : listaProductos) {
			tabla.addCell(productos.getFechaRegistro().toString());
			tabla.addCell(productos.getNombreInsumo());
			tabla.addCell(productos.getDescripccionInsumo());
			tabla.addCell(String.valueOf(productos.getPrecioInsumo()));
			tabla.addCell(String.valueOf(productos.getCantidadDisponible()));
			tabla.addCell(productos.getFechaVencimientoInsumo().toString());
	
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
		tabla.setWidths(new float[] { 3f, 2.3f, 4f, 4f, 2.9f, 3.5f });
		tabla.setWidthPercentage(110);

		escribirCabeceraDeLaTabla(tabla);
		escribirDatosDeLaTabla(tabla);

		documento.add(tabla);
		documento.close();
	}
}
