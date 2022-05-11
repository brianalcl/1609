package games.g2048.logic;

import java.awt.Color;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

import javax.swing.Icon;

import java.util.Map.Entry;

import general.logic.Cell;
import general.logic.GraphicCell;
import general.logic.Map;
import imageFactory.ImageFactory;

public class Piece{
	protected int num;
	protected Cell[][] cells;
	protected Map map;
	protected ImageFactory imageFactory;
	protected java.util.Map<Integer, Icon> mapIcon;
	protected java.util.Map<Integer, Color> mapColor;

	public Piece(int row, int column, Map map, ImageFactory imageFactory) {
		int rowMap = row * 2 + 2;
		int columnMap = column * 3 + 3;
		this.num = 0;
		this.map = map;
		this.cells = new Cell[2][3];
		this.imageFactory = imageFactory;
		this.mapIcon = new HashMap<>();
		this.mapColor = new HashMap<>();
		
		cells[0][0] = this.map.getCell(rowMap, columnMap - 1);	//top-left position
		cells[0][1] = this.map.getCell(rowMap, columnMap);		//top-central position
		cells[0][2] = this.map.getCell(rowMap, columnMap + 1);	//top-right position
		
		cells[1][0] = this.map.getCell(rowMap - 1, columnMap - 1);	//bottom-left position
		cells[1][1] = this.map.getCell(rowMap - 1, columnMap);		//bottom-central position
		cells[1][2] = this.map.getCell(rowMap - 1, columnMap + 1);	//bottom-right position
		
		mapIcon.put(-1, this.imageFactory.getEmptyNumber());
		mapIcon.put(0, this.imageFactory.get0());
		mapIcon.put(1, this.imageFactory.get1());
		mapIcon.put(2, this.imageFactory.get2());
		mapIcon.put(3, this.imageFactory.get3());
		mapIcon.put(4, this.imageFactory.get4());
		mapIcon.put(5, this.imageFactory.get5());
		mapIcon.put(6, this.imageFactory.get6());
		mapIcon.put(7, this.imageFactory.get7());
		mapIcon.put(8, this.imageFactory.get8());
		mapIcon.put(9, this.imageFactory.get9());
		
		mapColor.put(2, this.imageFactory.getColorAqua());
		mapColor.put(4, this.imageFactory.getColorAquamarine());
		mapColor.put(8, this.imageFactory.getColorDarkCyan());
		mapColor.put(16, this.imageFactory.getColorChartreuse());
		mapColor.put(32, this.imageFactory.getColorCoral());
		mapColor.put(64, this.imageFactory.getColorCrimson());
		mapColor.put(128, this.imageFactory.getColorBlueViolet());
		mapColor.put(256, this.imageFactory.getColorRebeccaPurple());
		mapColor.put(512, this.imageFactory.getColorDarkBlue());
		mapColor.put(1024, this.imageFactory.getColorDarkOrange());
		mapColor.put(2048, this.imageFactory.getColorDarkGreen());
		mapColor.put(4096, this.imageFactory.getColorGold());
		mapColor.put(8192, this.imageFactory.getColorGold());
		mapColor.put(16384, this.imageFactory.getColorGold());
		mapColor.put(32768, this.imageFactory.getColorGold());
		mapColor.put(65536, this.imageFactory.getColorGold());
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
	
	public int getNum() {
		return this.num;
	}
	
	public boolean equals(Piece p) {
		return p.num == this.num && this.num != 0;
	}
	
	public void put(int num) {
		
		this.num = num;
		
		if(num > 0 && num < 10) {
			cells[0][0].put(new GraphicCell(mapIcon.get(-1), mapColor.get(num)));	//top-left position
			cells[0][1].put(new GraphicCell(mapIcon.get(num), mapColor.get(num)));		//top-central position
			cells[0][2].put(new GraphicCell(mapIcon.get(-1), mapColor.get(num)));	//top-right position

			cells[1][0].put(new GraphicCell(mapIcon.get(-1), mapColor.get(num)));	//bottom-left position
			cells[1][1].put(new GraphicCell(mapIcon.get(-1), mapColor.get(num)));	//bottom-central position
			cells[1][2].put(new GraphicCell(mapIcon.get(-1), mapColor.get(num)));	//bottom-right position
		}

		if(num > 10 && num < 100) {
			cells[0][0].put(new GraphicCell(mapIcon.get(num / 10), mapColor.get(num)));	//top-left position
			cells[0][1].put(new GraphicCell(mapIcon.get(num % 10), mapColor.get(num)));		//top-central position
			cells[0][2].put(new GraphicCell(mapIcon.get(-1), mapColor.get(num)));	//top-right position

			cells[1][0].put(new GraphicCell(mapIcon.get(-1), mapColor.get(num)));	//bottom-left position
			cells[1][1].put(new GraphicCell(mapIcon.get(-1), mapColor.get(num)));		//bottom-central position
			cells[1][2].put(new GraphicCell(mapIcon.get(-1), mapColor.get(num)));	//bottom-right position
		}
		
		if(num > 100 && num < 1000) {
			cells[0][0].put(new GraphicCell(mapIcon.get(num / 100), mapColor.get(num)));	//top-left position
			cells[0][1].put(new GraphicCell(mapIcon.get((num / 10) % 10), mapColor.get(num)));		//top-central position
			cells[0][2].put(new GraphicCell(mapIcon.get(num % 10), mapColor.get(num)));	//top-right position

			cells[1][0].put(new GraphicCell(mapIcon.get(-1), mapColor.get(num)));	//bottom-left position
			cells[1][1].put(new GraphicCell(mapIcon.get(-1), mapColor.get(num)));		//bottom-central position
			cells[1][2].put(new GraphicCell(mapIcon.get(-1), mapColor.get(num)));	//bottom-right position
		}
		
		if(num > 1000 && num < 10000) {
			cells[0][0].put(new GraphicCell(mapIcon.get(num / 1000), mapColor.get(num)));	//top-left position
			cells[0][1].put(new GraphicCell(mapIcon.get((num / 100) % 10), mapColor.get(num)));		//top-central position
			cells[0][2].put(new GraphicCell(mapIcon.get((num / 10) % 10), mapColor.get(num)));	//top-right position

			cells[1][0].put(new GraphicCell(mapIcon.get(-1), mapColor.get(num)));	//bottom-left position
			cells[1][1].put(new GraphicCell(mapIcon.get(num % 10), mapColor.get(num)));		//bottom-central position
			cells[1][2].put(new GraphicCell(mapIcon.get(-1), mapColor.get(num)));	//bottom-right position
		}
		
		if(num > 10000 && num < 100000) {
			cells[0][0].put(new GraphicCell(mapIcon.get(num / 10000), mapColor.get(num)));	//top-left position
			cells[0][1].put(new GraphicCell(mapIcon.get((num / 1000) % 10), mapColor.get(num)));		//top-central position
			cells[0][2].put(new GraphicCell(mapIcon.get((num / 100) % 10), mapColor.get(num)));	//top-right position

			cells[1][0].put(new GraphicCell(mapIcon.get((num / 10) % 10), mapColor.get(num)));	//bottom-left position
			cells[1][1].put(new GraphicCell(mapIcon.get(num % 100), mapColor.get(num)));		//bottom-central position
			cells[1][2].put(new GraphicCell(mapIcon.get(-1), mapColor.get(num)));	//bottom-right position
		}
	}
}
