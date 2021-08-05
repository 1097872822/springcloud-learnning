package com.rrw.donate.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @description:
 * @author: RRW friend_rrw@163.com
 * @create: 2021-08-05 22:08
 */
@Data
@TableName("t_order_charging")
public class TOrderChargingEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id id
     */
    @TableId
    private Long id;
    /**
     * uuid UUID
     */
    private String uuid;
    /**
     * 充电桩ID
     */
    private Long pileId;
    /**
     * 是否我方用户在第三方充电的订单：0系统桩订单、1互联互通桩订单
     */
    private Integer interconnectionFlag;
    /**
     * 长订单号 - 互联互通订单号
     */
    private String longOrderNo;
    /**
     * 订单编号
     */
    private String orderNo;
    /**
     * 订单名称
     */
    private String orderName;
    /**
     * 订单是否完成：；0未完成、1已完成、2异常订单
     */
    private Integer isOver;
    /**
     * 接收充电桩上送数据标志：0未接收、1已接收、2待上报账单
     */
    private Integer receiveFlag;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户16位标示号
     */
    private String userShortId;
    /**
     * 设备协议类型:0新协议、1旧协议
     */
    private Integer protocolType;
    /**
     * Vin，17位字符串
     */
    private String vin;
    /**
     * 用户账户类型： 0APP、1卡、2VIN、3、企业用户、4微信公众号、5微信小程序、6互联互通
     */
    private Integer userType;
    /**
     * 运营商绑定的支付通道ID
     */
    private String payUuid;
    /**
     * 运营商ID
     */
    private Long agentId;
    /**
     * 运营商名称
     */
    private String agentName;
    /**
     * 是否企业员工订单： 0普通用户、1企业用户可使用企业资金池、2平台订单(互联互通订单)
     */
    private Integer companyFlag;
    /**
     * 企业ID
     */
    private Long companyId;
    /**
     * 企业名称
     */
    private String companyName;
    /**
     * 订单类型：1刷卡在线充电、2移动app充电、3vin充电、4刷卡离线充电、5微信公众号充电、6微信小程序充电、7互联互通充电
     */
    private Integer orderType;
    /**
     * 订单标志： 0平台订单、1第三方平台订单
     */
    private Integer orderFlag;
    /**
     * 停机控制码 - 针对充电订单进行停车充电时
     */
    private String stopCode;
    /**
     * 支付状态： :0未支付、1已支付
     */
    private Integer payStatus;
    /**
     * 开始时间
     */
    private String startTime;
    /**
     * 结束时间
     */
    private String endTime;
    /**
     * 充电方式:01：电量控制充电；02：时间控制充电；03：金额控制充电；04：自动充满05：定时启动充电
     */
    private String chargingType;
    /**
     * 用户选择充电量 度、千瓦时/充电金额/单位：分钟,配合charging_type使用
     */
    private BigDecimal chargingNumber;
    /**
     * 充电标示号，充电桩启动充电成功后返回的
     */
    private String chargingMark;
    /**
     * 起始SOC 百分比
     */
    private Integer startSoc;
    /**
     * 结束SOC 百分比
     */
    private Integer endSoc;
    /**
     * 充电总电量
     */
    private BigDecimal totalElec;
    /**
     * 充电桩上传的充电时长：秒
     */
    private Long totalTime;
    /**
     * 起始电表值
     */
    private BigDecimal startMeter;
    /**
     * 结束电表值
     */
    private BigDecimal endMeter;
    /**
     * 起始余额 单位：元
     */
    private BigDecimal startAmount;
    /**
     * 结束余额 单位：元
     */
    private BigDecimal endAmount;
    /**
     * 充电费 单位：元
     */
    private BigDecimal chargingFee;
    /**
     * 服务费 单位：元
     */
    private BigDecimal serviceFee;
    /**
     * 总费用 单位：元
     */
    private BigDecimal totalAmount;
    /**
     * 实收费用： 单位：元
     */
    private BigDecimal actualAmount;
    /**
     * 服务费ID
     */
    private Long serviceId;
    /**
     * 是否开发票： 0未开发票、1开具发票
     */
    private Integer invoiceFlag;
    /**
     * 充电桩出厂编号
     */
    private String pileSn;
    /**
     * 充电桩名称
     */
    private String pileName;
    /**
     * 通讯编号，默认14位
     */
    private String communicationSn;
    /**
     * 充电桩设备编号
     */
    private String driveNo;
    /**
     * 充电枪ID
     */
    private Long gunId;
    /**
     * 充电枪编号
     */
    private Integer gunNo;
    /**
     * TCU编号
     */
    private Integer tcuSn;
    /**
     * 充电枪类型 0交流、1直流、2交直流一体
     */
    private Integer gunType;
    /**
     * 充电桩归属电站ID
     */
    private Long stationId;
    /**
     * 充电站名称
     */
    private String stationName;
    /**
     * 是否收取停车费: 0免费、1收费
     */
    private Integer parkingFeeFlag;
    /**
     * 卡ID
     */
    private Long cardId;
    /**
     * 创建时间 创建时间
     */
    private String createTime;
    /**
     * 创建人 创建人
     */
    private String createBy;
    /**
     * 最后更新时间 最后更新时间
     */
    private String updateTime;
    /**
     * 最后更新人 最后更新人
     */
    private String updateBy;
    /**
     * 卡号
     */
    private String cardSn;
    /**
     * 卡类型：0用户卡、1员工卡、2管理卡
     */
    private Integer cardType;
    /**
     * 网点ID
     */
    private Long branchId;
    /**
     * 网点名称
     */
    private String branchName;
    /**
     * 充电前卡余额(平台记录的卡余额)
     */
    private BigDecimal cardBalance;
    /**
     * 是否并行充电：0常规充电、1并机充电
     */
    private Integer mergeFlag;
    /**
     * 并机汇总订单标记：0汇总订单(需要扣款)、1分机订单
     */
    private Integer mergeOrderFlag;
    /**
     * 并机主枪标记：0主枪订单、1从枪订单
     */
    private Integer masterGunFlag;
    /**
     * 折扣规则ID
     */
    private Long discountId;
    /**
     * 折扣规则名称
     */
    private String discountName;
    /**
     * 充电费折扣比例
     */
    private BigDecimal elecDiscount;
    /**
     * 服务费折扣比例
     */
    private BigDecimal serviceDiscount;
    /**
     * 总金额折扣比例
     */
    private BigDecimal totalDiscount;
    /**
     * 原始服务费折扣金额保留四位小数(单位：元)
     */
    private BigDecimal oldDiscountServiceAmount;
    /**
     * 服务费折扣金额(单位：元)
     */
    private BigDecimal discountServiceAmount;
    /**
     * 原始充电费折扣金额保留四位小数(单位：元)
     */
    private BigDecimal oldDiscountChargerAmount;
    /**
     * 充电费折扣金额(单位：元)
     */
    private BigDecimal discountChargerAmount;
    /**
     * 原始充电订单总金额折扣,保留四位小数(单位：元)
     */
    private BigDecimal oldDiscountOrderAmount;
    /**
     * 充电订单总金额折扣(单位：元)
     */
    private BigDecimal discountOrderAmount;
    /**
     * 抵扣规则主表ID
     */
    private Long deductionMasterId;
    /**
     * 抵扣规则名称
     */
    private String deductionName;
    /**
     * 抵扣规则明细ID
     */
    private Long deductionId;
    /**
     * 起始抵扣金额
     */
    private BigDecimal deductionStartAmount;
    /**
     * 抵扣金额(单位：元)
     */
    private BigDecimal deductionAmount;
    /**
     * 抵扣订单金额(单位：元)
     */
    private BigDecimal deductionOrderAmount;
    /**
     * 抵扣开始时间
     */
    private String deductionStartTime;
    /**
     * 抵扣结束时间
     */
    private String deductionEndTime;
    /**
     * 优惠类型：0无优惠、1明细折扣、2总价折扣、3满减、4混合优惠(折扣与满减一起使用)、5优惠卷
     */
    private Integer discountFlag;
    /**
     * 卡用户手机号
     */
    private String cardName;
    /**
     * 第三方运营商ID
     */
    private String operatorId;
    /**
     * 第三方运营商名称
     */
    private String operatorName;
    /**
     * 结算时间
     */
    private String settlementTime;
    /**
     * 桩上报的卡余额
     */
    private BigDecimal pileCardBalance;
    /**
     * 设备厂商ID
     */
    private Long vendorId;
    /**
     * 设备厂商名称
     */
    private String vendorName;
    /**
     * 故障类型说明
     */
    private String stopReason;
    /**
     * 结束状态：0正常结束、1故障结束
     */
    private Integer stopStatus;
    /**
     * 结束详情
     */
    private String stopDetails;
    /**
     * 停止状态说明
     */
    private String stopStatusDesc;
    /**
     * 互联互通运营商设备ID
     */
    private String connectorId;
    /**
     * 用户优惠卷ID
     */
    private Long userCouponId;
    /**
     * 抵扣券别名
     */
    private String userCouponName;
    /**
     * 抵扣金额
     */
    private BigDecimal userCouponAmount;
    /**
     * 起始抵扣金额
     */
    private BigDecimal userCouponInitialAmount;
    /**
     * 实际抵扣金额
     */
    private BigDecimal actualCouponAmount;
    /**
     * 桩上报的原始服务费
     */
    private BigDecimal oldServiceFee;
    /**
     * 里程数
     */
    private BigDecimal odometer;
    /**
     * 车牌号码
     */
    private String cartNo;
    /**
     * 停车系统推送标记：0未推送，1已推送
     */
    private Integer parkFlag;
    /**
     * 是否删除: :0正常、1删除
     */
    private Integer delFlag;
    /**
     * 备注
     */
    private String remark;

}