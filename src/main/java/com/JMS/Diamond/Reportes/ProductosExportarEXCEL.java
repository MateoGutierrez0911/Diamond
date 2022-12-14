package com.JMS.Diamond.Reportes;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.JMS.Diamond.modelo.Productos;

public class ProductosExportarEXCEL {


	private XSSFWorkbook libro;
	private XSSFSheet hoja;

	private List<Productos> listaProductos;

	public ProductosExportarEXCEL(List<Productos> listaProductos) {
		this.listaProductos = listaProductos;
		libro = new XSSFWorkbook();
		hoja = libro.createSheet("Empleados");
	}

	private void escribirCabeceraDeTabla() {
		Row fila = hoja.createRow(0);
		
		CellStyle estilo = libro.createCellStyle();
		XSSFFont fuente = libro.createFont();
		fuente.setBold(true);
		fuente.setFontHeight(16);
		estilo.setFont(fuente);
		
		Cell celda = fila.createCell(0);

		
		celda = fila.createCell(1);
		celda.setCellValue("Fecha de registro");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(2);
		celda.setCellValue("nombre del Insumo");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(3);
		celda.setCellValue("descripcion del Insumo");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(4);
		celda.setCellValue("Precio del Insumo");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(5);
		celda.setCellValue("cantidad Disponible");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(6);
		celda.setCellValue("fecha Vencimiento Insumo");
		celda.setCellStyle(estilo);
		
		
	}
	
	private void escribirDatosDeLaTabla() {
		int nueroFilas = 1;
		
		CellStyle estilo = libro.createCellStyle();
		XSSFFont fuente = libro.createFont();
		fuente.setFontHeight(14);
		estilo.setFont(fuente);
		
		for(Productos productos : listaProductos) {
			Row fila = hoja.createRow(nueroFilas ++);
			
			Cell celda = fila.createCell(0);

			
			celda = fila.createCell(1);
			celda.setCellValue(productos.getFechaRegistro().toString());
			hoja.autoSizeColumn(1);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(2);
			celda.setCellValue(productos.getNombreInsumo());
			hoja.autoSizeColumn(2);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(3);
			celda.setCellValue(productos.getDescripccionInsumo());
			hoja.autoSizeColumn(3);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(4);
			celda.setCellValue(productos.getPrecioInsumo());
			hoja.autoSizeColumn(4);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(5);
			celda.setCellValue(productos.getCantidadDisponible());
			hoja.autoSizeColumn(5);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(6);
			celda.setCellValue(productos.getFechaVencimientoInsumo().toString());
			hoja.autoSizeColumn(6);
			celda.setCellStyle(estilo);
			

		}
	}
	
	public void exportar(HttpServletResponse response) throws IOException {
		escribirCabeceraDeTabla();
		escribirDatosDeLaTabla();
		
		ServletOutputStream outPutStream = response.getOutputStream();
		libro.write(outPutStream);
		
		libro.close();
		outPutStream.close();
	}
}
