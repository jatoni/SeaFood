package com.mx.sea.food.dao;

import java.util.List;

import com.mx.sea.food.entity.TbPiecepackage;

public interface PiecePackageDAO {

	/**
	 * @return {@link TbPiecepackage} retorna una lista de pieza o paquete
	 */
	List<TbPiecepackage> getAllPieces();
}
