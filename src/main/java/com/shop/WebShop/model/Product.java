package com.shop.WebShop.model;

public class Product {

	public Product() {
	}
	 public Product(int brand_Id, int category_Id, String product_Description, String color, String product_Size,
			int quantity, float price, String image, String name, String material) {
		super();
		Brand_Id = brand_Id;
		Category_Id = category_Id;
		Product_Description = product_Description;
		Color = color;
		Product_Size = product_Size;
		Quantity = quantity;
		Price = price;
		Image = image;
		Name = name;
		Material = material;
	}
	private int Id;
	    private int Brand_Id;
	    private int Category_Id;
	    private String  Product_Description;
	    private String Color;
	    private String Product_Size;
	    private int Quantity;
	    private float  Price;
	    private String Image;
	    private String Name;
	    private String Material;
		public int getId() {
			return Id;
		}
		public void setId(int id) {
			Id = id;
		}
		public int getBrand_Id() {
			return Brand_Id;
		}
		public void setBrand_Id(int brand_Id) {
			Brand_Id = brand_Id;
		}
		public int getCategory_Id() {
			return Category_Id;
		}
		public void setCategory_Id(int category_Id) {
			Category_Id = category_Id;
		}
		public String getProduct_Description() {
			return Product_Description;
		}
		public void setProduct_Description(String product_Description) {
			Product_Description = product_Description;
		}
		public String getColor() {
			return Color;
		}
		public void setColor(String color) {
			Color = color;
		}
		public String getProduct_Size() {
			return Product_Size;
		}
		public void setProduct_Size(String product_Size) {
			Product_Size = product_Size;
		}
		public int getQuantity() {
			return Quantity;
		}
		public void setQuantity(int quantity) {
			Quantity = quantity;
		}
		public float getPrice() {
			return Price;
		}
		public void setPrice(float price) {
			Price = price;
		}
		public String getImage() {
			return Image;
		}
		public void setImage(String image) {
			Image = image;
		}
		public String getName() {
			return Name;
		}
		public void setName(String name) {
			Name = name;
		}
		public String getMaterial() {
			return Material;
		}
		public void setMaterial(String material) {
			Material = material;
		}

}
