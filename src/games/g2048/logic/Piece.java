package games.g2048.logic;

import java.awt.Color;
import java.util.HashMap;

import javax.swing.Icon;

import general.logic.Cell;
import general.logic.GraphicCell;
import general.logic.Map;
import imageFactory.ImageFactory;

public class Piece{
	protected int num;
	protected Cell[][] cells;
	protected Map map;
	protected ImageFactory imageFactory;
	protected java.util.Map<Integer, Color> mapColor;

	public Piece(int row, int column, Map map, ImageFactory imageFactory) {
		int rowMap = row * 2 + 2;
		int columnMap = column * 3 + 3;
		this.num = 0;
		this.map = map;
		this.cells = new Cell[2][3];
		this.imageFactory = imageFactory;
		this.mapColor = new HashMap<>();
		
		cells[0][0] = this.map.getCell(rowMap, columnMap - 1);	//top-left position
		cells[0][1] = this.map.getCell(rowMap, columnMap);		//top-central position
		cells[0][2] = this.map.getCell(rowMap, columnMap + 1);	//top-right position
		
		cells[1][0] = this.map.getCell(rowMap - 1, columnMap - 1);	//bottom-left position
		cells[1][1] = this.map.getCell(rowMap - 1, columnMap);		//bottom-central position
		cells[1][2] = this.map.getCell(rowMap - 1, columnMap + 1);	//bottom-right position
		
		
		mapColor.put(2, this.imageFactory.getColorPeru());
		mapColor.put(4, this.imageFactory.getColorSienna());
		mapColor.put(8, this.imageFactory.getColorDarkCyan());
		mapColor.put(16, this.imageFactory.getColorDarkSlateGray());
		mapColor.put(32, this.imageFactory.getColorMediumOrchid());
		mapColor.put(64, this.imageFactory.getColorPurple());
		mapColor.put(128, this.imageFactory.getColorDarkOliveGreen());
		mapColor.put(256, this.imageFactory.getColorDarkGreen());
		mapColor.put(512, this.imageFactory.getColorCrimson());
		mapColor.put(1024, this.imageFactory.getColorDarkRed());
		mapColor.put(2048, this.imageFactory.getColorRoyalBlue());
		mapColor.put(4096, this.imageFactory.getColorDarkGoldenRod());
		mapColor.put(8192, this.imageFactory.getColorDarkGoldenRod());
		mapColor.put(16384, this.imageFactory.getColorDarkGoldenRod());
		mapColor.put(32768, this.imageFactory.getColorDarkGoldenRod());
		mapColor.put(65536, this.imageFactory.getColorDarkGoldenRod());
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
		GraphicCell gc = new GraphicCell(null, mapColor.get(num));
		GraphicCell gcEmpty = new GraphicCell(null, mapColor.get(num));
		if(num > 0 && num < 10) {
			gc.setText(num+"");
			cells[0][0].put(gcEmpty);	//top-left position
			cells[0][1].put(gc);		//top-central position
			cells[0][2].put(gcEmpty);	//top-right position
			cells[1][0].put(gcEmpty);	//bottom-left position
			cells[1][1].put(gcEmpty);	//bottom-central position
			cells[1][2].put(gcEmpty);	//bottom-right position
		}

		if(num > 10 && num < 100) {
			gc.setText((num / 10)+"");
			cells[0][0].put(gc);	//top-left position
			gc.setText((num % 10)+"");
			cells[0][1].put(gc);		//top-central position
			cells[0][2].put(gcEmpty);	//top-right position
			cells[1][0].put(gcEmpty);	//bottom-left position
			cells[1][1].put(gcEmpty);		//bottom-central position
			cells[1][2].put(gcEmpty);	//bottom-right position
		}
		
		if(num > 100 && num < 1000) {
			gc.setText((num / 100)+"");
			cells[0][0].put(gc);	//top-left position
			gc.setText(((num / 10) % 10)+"");
			cells[0][1].put(gc);		//top-central position
			gc.setText((num % 10)+"");
			cells[0][2].put(gc);	//top-right position
			cells[1][0].put(gcEmpty);	//bottom-left position
			cells[1][1].put(gcEmpty);		//bottom-central position
			cells[1][2].put(gcEmpty);	//bottom-right position
		}
		
		if(num > 1000 && num < 10000) {
			gc.setText((num / 1000)+"");
			cells[0][0].put(gc);	//top-left position
			gc.setText(((num / 100) % 10)+"");
			cells[0][1].put(gc);		//top-central position
			gc.setText(((num / 10) % 10)+"");
			cells[0][2].put(gc);	//top-right position
			cells[1][0].put(gcEmpty);	//bottom-left position
			gc.setText((num % 10)+"");
			cells[1][1].put(gc);		//bottom-central position
			cells[1][2].put(gcEmpty);	//bottom-right position
		}
		
		if(num > 10000 && num < 100000) {
			gc.setText((num / 10000)+"");
			cells[0][0].put(gc);	//top-left position
			gc.setText(((num / 1000) % 10)+"");
			cells[0][1].put(gc);		//top-central position
			gc.setText(((num / 100) % 10)+"");
			cells[0][2].put(gc);	//top-right position
			gc.setText(((num / 10) % 10)+"");
			cells[1][0].put(gc);	//bottom-left position
			gc.setText((num % 10)+"");
			cells[1][1].put(gc);		//bottom-central position
			cells[1][2].put(gcEmpty);	//bottom-right position
		}
	}
}
