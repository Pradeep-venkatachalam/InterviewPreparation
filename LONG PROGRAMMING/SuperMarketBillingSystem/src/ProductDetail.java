public class ProductDetail {
    int ProductId;
    String ProductName;
    double ProductPrice ;

    public ProductDetail(){

    }

    ProductDetail(int ProductId,String ProductName,double ProductPrice ){
        this.ProductId=ProductId;
        this.ProductName=ProductName;
        this.ProductId=ProductId;
    }

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int productId) {
        ProductId = productId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public double getProductPrice() {
        return ProductPrice;
    }

    public void setProductPrice(double productPrice) {
        ProductPrice = productPrice;
    }

    @Override
    public String toString() {
        return
                "ProductId=" + ProductId +
                "\nProductName='" + ProductName +
                "\nProductPrice=" + ProductPrice ;
    }
}
