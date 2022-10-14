package games.g2048.logic;

import java.awt.Color;

import factory.Factory;
import general.logic.Cell;
import general.logic.GraphicCell;

public class Piece_G2048{
	protected int num;
	protected Cell[][] cells;
	protected Map_G2048 map;
	protected Factory imageFactory;

	public Piece_G2048(int row, int column, Map_G2048 map, Factory imageFactory) {
		int rowMap = row * 2 + 2;
		int columnMap = column * 3 + 3;
		this.num = 0;
		this.map = map;
		this.cells = new Cell[2][3];
		this.imageFactory = imageFactory;

		cells[0][0] = this.map.getCell(rowMap, columnMap - 1);	//top-left position
		cells[0][1] = this.map.getCell(rowMap, columnMap);		//top-central position
		cells[0][2] = this.map.getCell(rowMap, columnMap + 1);	//top-right position
		
		cells[1][0] = this.map.getCell(rowMap - 1, columnMap - 1);	//bottom-left position
		cells[1][1] = this.map.getCell(rowMap - 1, columnMap);		//bottom-central position
		cells[1][2] = this.map.getCell(rowMap - 1, columnMap + 1);	//bottom-right position
		
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
	
	public boolean equals(Piece_G2048 p) {
		return p.num == this.num && this.num != 0;
	}
	
	public void put(int num) {
		
		this.num = num;
		Color gcColor = map.getColorOfPiece(num);
		
		GraphicCell gc1 = new GraphicCell(null, gcColor);
		GraphicCell gc2 = new GraphicCell(null, gcColor);
		GraphicCell gc3 = new GraphicCell(null, gcColor);
		GraphicCell gc4 = new GraphicCell(null, gcColor);
		GraphicCell gc5 = new GraphicCell(null, gcColor);
		GraphicCell gc6 = new GraphicCell(null, gcColor);
		
		if(num > 0 && num < 100) {
			gc1.setForeground(imageFactory.getColorForeground());
			gc2.setForeground(imageFactory.getColorForeground());
			gc3.setForeground(imageFactory.getColorForeground());
			gc4.setForeground(imageFactory.getColorForeground());
			gc5.setForeground(imageFactory.getColorForeground());
			gc6.setForeground(imageFactory.getColorForeground());
		}
		
		if(num > 0 && num < 10) {
			
			cells[0][0].put(gc1);				//top-left position
			gc2.setText(num+"");
			cells[0][1].put(gc2);				//top-central position
			cells[0][2].put(gc3);				//top-right position
			cells[1][0].put(gc4);				//bottom-left position
			cells[1][1].put(gc5);				//bottom-central position
			cells[1][2].put(gc6);				//bottom-right position
		}

		if(num > 10 && num < 100) {
			gc1.setText((num / 10)+"");
			cells[0][0].put(gc1);				//top-left position
			gc2.setText((num % 10)+"");
			cells[0][1].put(gc2);				//top-central position
			cells[0][2].put(gc3);				//top-right position
			cells[1][0].put(gc4);				//bottom-left position
			cells[1][1].put(gc5);				//bottom-central position
			cells[1][2].put(gc6);				//bottom-right position
		}
		
		if(num > 100 && num < 100000) {
			gc1.setForeground(imageFactory.getColorDefault());
			gc2.setForeground(imageFactory.getColorDefault());
			gc3.setForeground(imageFactory.getColorDefault());
			gc4.setForeground(imageFactory.getColorDefault());
			gc5.setForeground(imageFactory.getColorDefault());
			gc6.setForeground(imageFactory.getColorDefault());
		}
		
		if(num > 100 && num < 1000) {
			gc1.setText((num / 100)+"");
			cells[0][0].put(gc1);				//top-left position
			gc2.setText(((num / 10) % 10)+"");
			cells[0][1].put(gc2);				//top-central position
			gc3.setText((num % 10)+"");
			cells[0][2].put(gc3);				//top-right position
			cells[1][0].put(gc4);				//bottom-left position
			cells[1][1].put(gc5);				//bottom-central position
			cells[1][2].put(gc6);				//bottom-right position
		}
		
		if(num > 1000 && num < 10000) {
			gc1.setText((num / 1000)+"");
			cells[0][0].put(gc1);				//top-left position
			gc2.setText(((num / 100) % 10)+"");
			cells[0][1].put(gc2);				//top-central position
			gc3.setText(((num / 10) % 10)+"");
			cells[0][2].put(gc3);				//top-right position
			cells[1][0].put(gc4);				//bottom-left position
			gc5.setText((num % 10)+"");
			cells[1][1].put(gc5);				//bottom-central position
			cells[1][2].put(gc6);				//bottom-right position
		}
		
		if(num > 10000 && num < 100000) {
			gc1.setText((num / 10000)+"");
			cells[0][0].put(gc1);				//top-left position
			gc2.setText(((num / 1000) % 10)+"");
			cells[0][1].put(gc2);				//top-central position
			gc3.setText(((num / 100) % 10)+"");
			cells[0][2].put(gc3);				//top-right position
			gc4.setText(((num / 10) % 10)+"");
			cells[1][0].put(gc4);				//bottom-left position
			gc5.setText((num % 10)+"");
			cells[1][1].put(gc5);				//bottom-central position
			cells[1][2].put(gc6);				//bottom-right position
		}
	}
}
