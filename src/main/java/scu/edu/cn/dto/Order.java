package scu.edu.cn.dto;

public class Order {
    Integer contractCount;

    Integer recentCount;
    Double price;

    public Order() {
    }

    public Order(Integer contractCount, Integer recentCount, Double price) {
        this.contractCount = contractCount;
        this.recentCount = recentCount;
        this.price = price;
    }

    public Integer getContractCount() {
        return contractCount;
    }

    public void setContractCount(Integer contractCount) {
        this.contractCount = contractCount;
    }

    public Integer getRecentCount() {
        return recentCount;
    }

    public void setRecentCount(Integer recentCount) {
        this.recentCount = recentCount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
