package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Products", schema = "Northwind", catalog = "")
public class ProductsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ProductID")
    private int productId;
    @Basic
    @Column(name = "ProductName")
    private String productName;
    @Basic
    @Column(name = "SupplierID")
    private Integer supplierId;
    @Basic
    @Column(name = "CategoryID")
    private Integer categoryId;
    @Basic
    @Column(name = "QuantityPerUnit")
    private String quantityPerUnit;
    @Basic
    @Column(name = "UnitPrice")
    private Double unitPrice;
    @Basic
    @Column(name = "UnitsInStock")
    private Short unitsInStock;
    @Basic
    @Column(name = "UnitsOnOrder")
    private Short unitsOnOrder;
    @Basic
    @Column(name = "ReorderLevel")
    private Short reorderLevel;
    @Basic
    @Column(name = "Discontinued")
    private byte discontinued;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getQuantityPerUnit() {
        return quantityPerUnit;
    }

    public void setQuantityPerUnit(String quantityPerUnit) {
        this.quantityPerUnit = quantityPerUnit;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Short getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(Short unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    public Short getUnitsOnOrder() {
        return unitsOnOrder;
    }

    public void setUnitsOnOrder(Short unitsOnOrder) {
        this.unitsOnOrder = unitsOnOrder;
    }

    public Short getReorderLevel() {
        return reorderLevel;
    }

    public void setReorderLevel(Short reorderLevel) {
        this.reorderLevel = reorderLevel;
    }

    public byte getDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(byte discontinued) {
        this.discontinued = discontinued;
    }
}
