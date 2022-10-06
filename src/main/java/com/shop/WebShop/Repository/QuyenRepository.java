package com.shop.WebShop.Repository;

import java.util.Optional;


import com.shop.WebShop.model.Quyen;


public interface QuyenRepository{
	Optional<Quyen> findByName(String name);
}
