package games.g2048.logic;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;

import general.logic.Cell;
import general.logic.GraphicCell;
import general.logic.Map;
import imageFactory.ImageFactory;

public class Piece{
	protected int num;
	protected Cell[][] cells;
	protected Map map;
	protected GraphicCell emptyNumber;
	protected ImageFactory imageFactory;
	protected java.util.Map<Integer, GraphicCell> jMap;

	public Piece(int row, int column, Map map, ImageFactory imageFactory) {
		int rowMap = row * 2 + 2;
		int columnMap = column * 3 + 3;
		this.num = 0;
		this.map = map;
		this.cells = new Cell[2][3];
		this.imageFactory = imageFactory;
		this.emptyNumber = new GraphicCell(this.imageFactory.getEmptyNumber(), this.imageFactory.getColorBrown());
		this.jMap = new HashMap<>();
		
		cells[0][0] = this.map.getCell(rowMap, columnMap - 1);	//top-left position
		cells[0][1] = this.map.getCell(rowMap, columnMap);		//top-central position
		cells[0][2] = this.map.getCell(rowMap, columnMap + 1);	//top-right position
		
		cells[1][0] = this.map.getCell(rowMap - 1, columnMap - 1);	//bottom-left position
		cells[1][1] = this.map.getCell(rowMap - 1, columnMap);		//bottom-central position
		cells[1][2] = this.map.getCell(rowMap - 1, columnMap + 1);	//bottom-right position
		
		jMap.put(0, new GraphicCell(this.imageFactory.get0(), this.imageFactory.getColorBrown()));
		jMap.put(1, new GraphicCell(this.imageFactory.get1(), this.imageFactory.getColorBrown()));
		jMap.put(2, new GraphicCell(this.imageFactory.get2(), this.imageFactory.getColorBrown()));
		jMap.put(3, new GraphicCell(this.imageFactory.get3(), this.imageFactory.getColorBrown()));
		jMap.put(4, new GraphicCell(this.imageFactory.get4(), this.imageFactory.getColorBrown()));
		jMap.put(5, new GraphicCell(this.imageFactory.get5(), this.imageFactory.getColorBrown()));
		jMap.put(6, new GraphicCell(this.imageFactory.get6(), this.imageFactory.getColorBrown()));
		jMap.put(7, new GraphicCell(this.imageFactory.get7(), this.imageFactory.getColorBrown()));
		jMap.put(8, new GraphicCell(this.imageFactory.get8(), this.imageFactory.getColorBrown()));
		jMap.put(9, new GraphicCell(this.imageFactory.get9(), this.imageFactory.getColorBrown()));
	}
	
	public void setNum(int num) {
		this.num = num;
	}

	public void clear() {
		this.num = 0;
		for (int r = 0; r < 2; r++)
			for(int c = 0; c < 3; c++) {
				cells[r][c].clear();
			}
	}

	public boolean isFree() {
		return cells[0][0].isFree();
	}

	public GraphicCell[][] getGraphicCell() {
		GraphicCell[][] ret = new GraphicCell[2][3];
		for (int r = 0; r < 2; r++)
			for (int c = 0; c < 3; c++) {
				ret[r][c] = cells[r][c].getGraphicCell();
			}
		return ret;
	}
	
	public int getNum() {
		return this.num;
	}
	
	public void put(GraphicCell[][] graphicCell, int num) {
		this.num = num;
		if (this.num != 0)
			for (int r = 0; r < 2; r++)
				for (int c = 0; c < 3; c++) {
					cells[r][c].put(graphicCell[r][c]);
				}
	}
	
	public boolean equals(Piece p) {
		return p.num == this.num && this.num != 0;
	}
	
	public void put(int num) {
		
		this.num = num;
		
		if(num > 0 && num < 10) {
			cells[0][0].put(emptyNumber);	//top-left position
			cells[0][1].put(jMap.get(num));		//top-central position
			cells[0][2].put(emptyNumber);	//top-right position

			cells[1][0].put(emptyNumber);	//bottom-left position
			cells[1][1].put(emptyNumber);		//bottom-central position
			cells[1][2].put(emptyNumber);	//bottom-right position
		}

		if(num > 10 && num < 100) {
			cells[0][0].put(jMap.get(num / 10));	//top-left position
			cells[0][1].put(jMap.get(num % 10));		//top-central position
			cells[0][2].put(emptyNumber);	//top-right position

			cells[1][0].put(emptyNumber);	//bottom-left position
			cells[1][1].put(emptyNumber);		//bottom-central position
			cells[1][2].put(emptyNumber);	//bottom-right position
		}
		
		if(num > 100 && num < 1000) {
			cells[0][0].put(jMap.get(num / 100));	//top-left position
			cells[0][1].put(jMap.get((num / 10) % 10));		//top-central position
			cells[0][2].put(jMap.get(num % 10));	//top-right position

			cells[1][0].put(emptyNumber);	//bottom-left position
			cells[1][1].put(emptyNumber);		//bottom-central position
			cells[1][2].put(emptyNumber);	//bottom-right position
		}
		
		if(num > 1000 && num < 10000) {
			cells[0][0].put(jMap.get(num / 1000));	//top-left position
			cells[0][1].put(jMap.get((num / 100) % 10));		//top-central position
			cells[0][2].put(jMap.get((num / 10) % 10));	//top-right position

			cells[1][0].put(emptyNumber);	//bottom-left position
			cells[1][1].put(jMap.get(num % 10));		//bottom-central position
			cells[1][2].put(emptyNumber);	//bottom-right position
		}
		
		if(num > 10000 && num < 100000) {
			cells[0][0].put(jMap.get(num / 10000));	//top-left position
			cells[0][1].put(jMap.get((num / 1000) % 10));		//top-central position
			cells[0][2].put(jMap.get((num / 100) % 10));	//top-right position

			cells[1][0].put(jMap.get((num / 10) % 10));	//bottom-left position
			cells[1][1].put(jMap.get(num % 10));		//bottom-central position
			cells[1][2].put(emptyNumber);	//bottom-right position
		}
	}
}
