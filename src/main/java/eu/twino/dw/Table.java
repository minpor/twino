package eu.twino.dw;

import eu.twino.exception.TwinoException;

public class Table implements Dataware {

	private String[][] table;

	public Table(int columnCount, int rowCount) {
		table = new String[rowCount][columnCount];
	}

	@Override
	public String put(int column, int row, String value) {
		String current = get(column, row);
		table[row - 1][column - 1] = value;
		return current;
	}

	@Override
	public String get(int column, int row) {
		checkForException(column, row);
		return table[row - 1][column - 1];
	}

	public String[][] getTable() {
		return table;
	}

	private void checkForException(int column, int row) {

		if (isColumnValid(column) && !isRowValid(row)) {
			throw new TwinoException("Некорректно задано значение строки");
		}

		if (!isColumnValid(column) && isRowValid(row)) {
			throw new TwinoException("Некорректно задано значение столбца");
		}

		if (!isColumnValid(column) && !isRowValid(row)) {
			throw new TwinoException("Некорректно заданы значения строки и столбца");
		}

	}

	private boolean isRowValid(int row) {
		return row >= 1 && row <= table.length;
	}

	private boolean isColumnValid(int column) {
		return column >= 1 && column <= table[0].length;
	}
}
