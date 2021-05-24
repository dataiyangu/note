//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.leesin.json.test;

import lombok.Data;

import java.io.Serializable;

@Data
public class ReviewLaunchReq implements Serializable {
    private String skuBarcode;
    private String carryCode;
    private String warehouseCode;
    private String staffNo;
    private String staffName;

    public ReviewLaunchReq() {
    }

    public String getSkuBarcode() {
        return this.skuBarcode;
    }

    public String getCarryCode() {
        return this.carryCode;
    }

    public String getWarehouseCode() {
        return this.warehouseCode;
    }

    public String getStaffNo() {
        return this.staffNo;
    }

    public String getStaffName() {
        return this.staffName;
    }

    public void setSkuBarcode(final String skuBarcode) {
        this.skuBarcode = skuBarcode;
    }

    public void setCarryCode(final String carryCode) {
        this.carryCode = carryCode;
    }

    public void setWarehouseCode(final String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    public void setStaffNo(final String staffNo) {
        this.staffNo = staffNo;
    }

    public void setStaffName(final String staffName) {
        this.staffName = staffName;
    }

    // public boolean equals(final Object o) {
    //     if (o == this) {
    //         return true;
    //     } else if (!(o instanceof ReviewLaunchReq)) {
    //         return false;
    //     } else {
    //         ReviewLaunchReq other = (ReviewLaunchReq)o;
    //         if (!other.canEqual(this)) {
    //             return false;
    //         } else {
    //             label71: {
    //                 Object this$skuBarcode = this.getSkuBarcode();
    //                 Object other$skuBarcode = other.getSkuBarcode();
    //                 if (this$skuBarcode == null) {
    //                     if (other$skuBarcode == null) {
    //                         break label71;
    //                     }
    //                 } else if (this$skuBarcode.equals(other$skuBarcode)) {
    //                     break label71;
    //                 }
    //
    //                 return false;
    //             }
    //
    //             Object this$carryCode = this.getCarryCode();
    //             Object other$carryCode = other.getCarryCode();
    //             if (this$carryCode == null) {
    //                 if (other$carryCode != null) {
    //                     return false;
    //                 }
    //             } else if (!this$carryCode.equals(other$carryCode)) {
    //                 return false;
    //             }
    //
    //             label57: {
    //                 Object this$warehouseCode = this.getWarehouseCode();
    //                 Object other$warehouseCode = other.getWarehouseCode();
    //                 if (this$warehouseCode == null) {
    //                     if (other$warehouseCode == null) {
    //                         break label57;
    //                     }
    //                 } else if (this$warehouseCode.equals(other$warehouseCode)) {
    //                     break label57;
    //                 }
    //
    //                 return false;
    //             }
    //
    //             Object this$staffNo = this.getStaffNo();
    //             Object other$staffNo = other.getStaffNo();
    //             if (this$staffNo == null) {
    //                 if (other$staffNo != null) {
    //                     return false;
    //                 }
    //             } else if (!this$staffNo.equals(other$staffNo)) {
    //                 return false;
    //             }
    //
    //             Object this$staffName = this.getStaffName();
    //             Object other$staffName = other.getStaffName();
    //             if (this$staffName == null) {
    //                 if (other$staffName == null) {
    //                     return true;
    //                 }
    //             } else if (this$staffName.equals(other$staffName)) {
    //                 return true;
    //             }
    //
    //             return false;
    //         }
    //     }
    // }

    protected boolean canEqual(final Object other) {
        return other instanceof ReviewLaunchReq;
    }

    // public int hashCode() {
    //     int PRIME = true;
    //     int result = 1;
    //     Object $skuBarcode = this.getSkuBarcode();
    //     int result = result * 59 + ($skuBarcode == null ? 43 : $skuBarcode.hashCode());
    //     Object $carryCode = this.getCarryCode();
    //     result = result * 59 + ($carryCode == null ? 43 : $carryCode.hashCode());
    //     Object $warehouseCode = this.getWarehouseCode();
    //     result = result * 59 + ($warehouseCode == null ? 43 : $warehouseCode.hashCode());
    //     Object $staffNo = this.getStaffNo();
    //     result = result * 59 + ($staffNo == null ? 43 : $staffNo.hashCode());
    //     Object $staffName = this.getStaffName();
    //     result = result * 59 + ($staffName == null ? 43 : $staffName.hashCode());
    //     return result;
    // }
    //
    // public String toString() {
    //     return "ReviewLaunchReq(skuBarcode=" + this.getSkuBarcode() + ", carryCode=" + this.getCarryCode() + ", warehouseCode=" + this.getWarehouseCode() + ", staffNo=" + this.getStaffNo() + ", staffName=" + this.getStaffName() + ")";
    // }
}
