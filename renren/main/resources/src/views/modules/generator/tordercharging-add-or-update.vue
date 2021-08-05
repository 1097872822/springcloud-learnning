<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="uuid UUID" prop="uuid">
      <el-input v-model="dataForm.uuid" placeholder="uuid UUID"></el-input>
    </el-form-item>
    <el-form-item label="是否我方用户在第三方充电的订单：0系统桩订单、1互联互通桩订单" prop="interconnectionFlag">
      <el-input v-model="dataForm.interconnectionFlag" placeholder="是否我方用户在第三方充电的订单：0系统桩订单、1互联互通桩订单"></el-input>
    </el-form-item>
    <el-form-item label="长订单号 - 互联互通订单号" prop="longOrderNo">
      <el-input v-model="dataForm.longOrderNo" placeholder="长订单号 - 互联互通订单号"></el-input>
    </el-form-item>
    <el-form-item label="订单编号" prop="orderNo">
      <el-input v-model="dataForm.orderNo" placeholder="订单编号"></el-input>
    </el-form-item>
    <el-form-item label="订单名称" prop="orderName">
      <el-input v-model="dataForm.orderName" placeholder="订单名称"></el-input>
    </el-form-item>
    <el-form-item label="订单是否完成：；0未完成、1已完成、2异常订单" prop="isOver">
      <el-input v-model="dataForm.isOver" placeholder="订单是否完成：；0未完成、1已完成、2异常订单"></el-input>
    </el-form-item>
    <el-form-item label="接收充电桩上送数据标志：0未接收、1已接收、2待上报账单" prop="receiveFlag">
      <el-input v-model="dataForm.receiveFlag" placeholder="接收充电桩上送数据标志：0未接收、1已接收、2待上报账单"></el-input>
    </el-form-item>
    <el-form-item label="用户ID" prop="userId">
      <el-input v-model="dataForm.userId" placeholder="用户ID"></el-input>
    </el-form-item>
    <el-form-item label="用户名" prop="userName">
      <el-input v-model="dataForm.userName" placeholder="用户名"></el-input>
    </el-form-item>
    <el-form-item label="用户16位标示号" prop="userShortId">
      <el-input v-model="dataForm.userShortId" placeholder="用户16位标示号"></el-input>
    </el-form-item>
    <el-form-item label="设备协议类型:0新协议、1旧协议" prop="protocolType">
      <el-input v-model="dataForm.protocolType" placeholder="设备协议类型:0新协议、1旧协议"></el-input>
    </el-form-item>
    <el-form-item label="Vin，17位字符串" prop="vin">
      <el-input v-model="dataForm.vin" placeholder="Vin，17位字符串"></el-input>
    </el-form-item>
    <el-form-item label="用户账户类型： 0APP、1卡、2VIN、3、企业用户、4微信公众号、5微信小程序、6互联互通" prop="userType">
      <el-input v-model="dataForm.userType" placeholder="用户账户类型： 0APP、1卡、2VIN、3、企业用户、4微信公众号、5微信小程序、6互联互通"></el-input>
    </el-form-item>
    <el-form-item label="运营商绑定的支付通道ID" prop="payUuid">
      <el-input v-model="dataForm.payUuid" placeholder="运营商绑定的支付通道ID"></el-input>
    </el-form-item>
    <el-form-item label="运营商ID" prop="agentId">
      <el-input v-model="dataForm.agentId" placeholder="运营商ID"></el-input>
    </el-form-item>
    <el-form-item label="运营商名称" prop="agentName">
      <el-input v-model="dataForm.agentName" placeholder="运营商名称"></el-input>
    </el-form-item>
    <el-form-item label="是否企业员工订单： 0普通用户、1企业用户可使用企业资金池、2平台订单(互联互通订单)" prop="companyFlag">
      <el-input v-model="dataForm.companyFlag" placeholder="是否企业员工订单： 0普通用户、1企业用户可使用企业资金池、2平台订单(互联互通订单)"></el-input>
    </el-form-item>
    <el-form-item label="企业ID" prop="companyId">
      <el-input v-model="dataForm.companyId" placeholder="企业ID"></el-input>
    </el-form-item>
    <el-form-item label="企业名称" prop="companyName">
      <el-input v-model="dataForm.companyName" placeholder="企业名称"></el-input>
    </el-form-item>
    <el-form-item label="订单类型：1刷卡在线充电、2移动app充电、3vin充电、4刷卡离线充电、5微信公众号充电、6微信小程序充电、7互联互通充电" prop="orderType">
      <el-input v-model="dataForm.orderType" placeholder="订单类型：1刷卡在线充电、2移动app充电、3vin充电、4刷卡离线充电、5微信公众号充电、6微信小程序充电、7互联互通充电"></el-input>
    </el-form-item>
    <el-form-item label="订单标志： 0平台订单、1第三方平台订单" prop="orderFlag">
      <el-input v-model="dataForm.orderFlag" placeholder="订单标志： 0平台订单、1第三方平台订单"></el-input>
    </el-form-item>
    <el-form-item label="停机控制码 - 针对充电订单进行停车充电时" prop="stopCode">
      <el-input v-model="dataForm.stopCode" placeholder="停机控制码 - 针对充电订单进行停车充电时"></el-input>
    </el-form-item>
    <el-form-item label="支付状态： :0未支付、1已支付" prop="payStatus">
      <el-input v-model="dataForm.payStatus" placeholder="支付状态： :0未支付、1已支付"></el-input>
    </el-form-item>
    <el-form-item label="开始时间" prop="startTime">
      <el-input v-model="dataForm.startTime" placeholder="开始时间"></el-input>
    </el-form-item>
    <el-form-item label="结束时间" prop="endTime">
      <el-input v-model="dataForm.endTime" placeholder="结束时间"></el-input>
    </el-form-item>
    <el-form-item label="充电方式:01：电量控制充电；02：时间控制充电；03：金额控制充电；04：自动充满05：定时启动充电" prop="chargingType">
      <el-input v-model="dataForm.chargingType" placeholder="充电方式:01：电量控制充电；02：时间控制充电；03：金额控制充电；04：自动充满05：定时启动充电"></el-input>
    </el-form-item>
    <el-form-item label="用户选择充电量 度、千瓦时/充电金额/单位：分钟,配合charging_type使用" prop="chargingNumber">
      <el-input v-model="dataForm.chargingNumber" placeholder="用户选择充电量 度、千瓦时/充电金额/单位：分钟,配合charging_type使用"></el-input>
    </el-form-item>
    <el-form-item label="充电标示号，充电桩启动充电成功后返回的" prop="chargingMark">
      <el-input v-model="dataForm.chargingMark" placeholder="充电标示号，充电桩启动充电成功后返回的"></el-input>
    </el-form-item>
    <el-form-item label="起始SOC 百分比" prop="startSoc">
      <el-input v-model="dataForm.startSoc" placeholder="起始SOC 百分比"></el-input>
    </el-form-item>
    <el-form-item label="结束SOC 百分比" prop="endSoc">
      <el-input v-model="dataForm.endSoc" placeholder="结束SOC 百分比"></el-input>
    </el-form-item>
    <el-form-item label="充电总电量" prop="totalElec">
      <el-input v-model="dataForm.totalElec" placeholder="充电总电量"></el-input>
    </el-form-item>
    <el-form-item label="充电桩上传的充电时长：秒" prop="totalTime">
      <el-input v-model="dataForm.totalTime" placeholder="充电桩上传的充电时长：秒"></el-input>
    </el-form-item>
    <el-form-item label="起始电表值" prop="startMeter">
      <el-input v-model="dataForm.startMeter" placeholder="起始电表值"></el-input>
    </el-form-item>
    <el-form-item label="结束电表值" prop="endMeter">
      <el-input v-model="dataForm.endMeter" placeholder="结束电表值"></el-input>
    </el-form-item>
    <el-form-item label="起始余额 单位：元" prop="startAmount">
      <el-input v-model="dataForm.startAmount" placeholder="起始余额 单位：元"></el-input>
    </el-form-item>
    <el-form-item label="结束余额 单位：元" prop="endAmount">
      <el-input v-model="dataForm.endAmount" placeholder="结束余额 单位：元"></el-input>
    </el-form-item>
    <el-form-item label="充电费 单位：元" prop="chargingFee">
      <el-input v-model="dataForm.chargingFee" placeholder="充电费 单位：元"></el-input>
    </el-form-item>
    <el-form-item label="服务费 单位：元" prop="serviceFee">
      <el-input v-model="dataForm.serviceFee" placeholder="服务费 单位：元"></el-input>
    </el-form-item>
    <el-form-item label="总费用 单位：元" prop="totalAmount">
      <el-input v-model="dataForm.totalAmount" placeholder="总费用 单位：元"></el-input>
    </el-form-item>
    <el-form-item label="实收费用： 单位：元" prop="actualAmount">
      <el-input v-model="dataForm.actualAmount" placeholder="实收费用： 单位：元"></el-input>
    </el-form-item>
    <el-form-item label="服务费ID" prop="serviceId">
      <el-input v-model="dataForm.serviceId" placeholder="服务费ID"></el-input>
    </el-form-item>
    <el-form-item label="是否开发票： 0未开发票、1开具发票" prop="invoiceFlag">
      <el-input v-model="dataForm.invoiceFlag" placeholder="是否开发票： 0未开发票、1开具发票"></el-input>
    </el-form-item>
    <el-form-item label="充电桩ID" prop="pileId">
      <el-input v-model="dataForm.pileId" placeholder="充电桩ID"></el-input>
    </el-form-item>
    <el-form-item label="充电桩出厂编号" prop="pileSn">
      <el-input v-model="dataForm.pileSn" placeholder="充电桩出厂编号"></el-input>
    </el-form-item>
    <el-form-item label="充电桩名称" prop="pileName">
      <el-input v-model="dataForm.pileName" placeholder="充电桩名称"></el-input>
    </el-form-item>
    <el-form-item label="通讯编号，默认14位" prop="communicationSn">
      <el-input v-model="dataForm.communicationSn" placeholder="通讯编号，默认14位"></el-input>
    </el-form-item>
    <el-form-item label="充电桩设备编号" prop="driveNo">
      <el-input v-model="dataForm.driveNo" placeholder="充电桩设备编号"></el-input>
    </el-form-item>
    <el-form-item label="充电枪ID" prop="gunId">
      <el-input v-model="dataForm.gunId" placeholder="充电枪ID"></el-input>
    </el-form-item>
    <el-form-item label="充电枪编号" prop="gunNo">
      <el-input v-model="dataForm.gunNo" placeholder="充电枪编号"></el-input>
    </el-form-item>
    <el-form-item label="TCU编号" prop="tcuSn">
      <el-input v-model="dataForm.tcuSn" placeholder="TCU编号"></el-input>
    </el-form-item>
    <el-form-item label="充电枪类型 0交流、1直流、2交直流一体" prop="gunType">
      <el-input v-model="dataForm.gunType" placeholder="充电枪类型 0交流、1直流、2交直流一体"></el-input>
    </el-form-item>
    <el-form-item label="充电桩归属电站ID" prop="stationId">
      <el-input v-model="dataForm.stationId" placeholder="充电桩归属电站ID"></el-input>
    </el-form-item>
    <el-form-item label="充电站名称" prop="stationName">
      <el-input v-model="dataForm.stationName" placeholder="充电站名称"></el-input>
    </el-form-item>
    <el-form-item label="是否收取停车费: 0免费、1收费" prop="parkingFeeFlag">
      <el-input v-model="dataForm.parkingFeeFlag" placeholder="是否收取停车费: 0免费、1收费"></el-input>
    </el-form-item>
    <el-form-item label="卡ID" prop="cardId">
      <el-input v-model="dataForm.cardId" placeholder="卡ID"></el-input>
    </el-form-item>
    <el-form-item label="创建时间 创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建时间 创建时间"></el-input>
    </el-form-item>
    <el-form-item label="创建人 创建人" prop="createBy">
      <el-input v-model="dataForm.createBy" placeholder="创建人 创建人"></el-input>
    </el-form-item>
    <el-form-item label="最后更新时间 最后更新时间" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="最后更新时间 最后更新时间"></el-input>
    </el-form-item>
    <el-form-item label="最后更新人 最后更新人" prop="updateBy">
      <el-input v-model="dataForm.updateBy" placeholder="最后更新人 最后更新人"></el-input>
    </el-form-item>
    <el-form-item label="卡号" prop="cardSn">
      <el-input v-model="dataForm.cardSn" placeholder="卡号"></el-input>
    </el-form-item>
    <el-form-item label="卡类型：0用户卡、1员工卡、2管理卡" prop="cardType">
      <el-input v-model="dataForm.cardType" placeholder="卡类型：0用户卡、1员工卡、2管理卡"></el-input>
    </el-form-item>
    <el-form-item label="网点ID" prop="branchId">
      <el-input v-model="dataForm.branchId" placeholder="网点ID"></el-input>
    </el-form-item>
    <el-form-item label="网点名称" prop="branchName">
      <el-input v-model="dataForm.branchName" placeholder="网点名称"></el-input>
    </el-form-item>
    <el-form-item label="充电前卡余额(平台记录的卡余额)" prop="cardBalance">
      <el-input v-model="dataForm.cardBalance" placeholder="充电前卡余额(平台记录的卡余额)"></el-input>
    </el-form-item>
    <el-form-item label="是否并行充电：0常规充电、1并机充电" prop="mergeFlag">
      <el-input v-model="dataForm.mergeFlag" placeholder="是否并行充电：0常规充电、1并机充电"></el-input>
    </el-form-item>
    <el-form-item label="并机汇总订单标记：0汇总订单(需要扣款)、1分机订单" prop="mergeOrderFlag">
      <el-input v-model="dataForm.mergeOrderFlag" placeholder="并机汇总订单标记：0汇总订单(需要扣款)、1分机订单"></el-input>
    </el-form-item>
    <el-form-item label="并机主枪标记：0主枪订单、1从枪订单" prop="masterGunFlag">
      <el-input v-model="dataForm.masterGunFlag" placeholder="并机主枪标记：0主枪订单、1从枪订单"></el-input>
    </el-form-item>
    <el-form-item label="折扣规则ID" prop="discountId">
      <el-input v-model="dataForm.discountId" placeholder="折扣规则ID"></el-input>
    </el-form-item>
    <el-form-item label="折扣规则名称" prop="discountName">
      <el-input v-model="dataForm.discountName" placeholder="折扣规则名称"></el-input>
    </el-form-item>
    <el-form-item label="充电费折扣比例" prop="elecDiscount">
      <el-input v-model="dataForm.elecDiscount" placeholder="充电费折扣比例"></el-input>
    </el-form-item>
    <el-form-item label="服务费折扣比例" prop="serviceDiscount">
      <el-input v-model="dataForm.serviceDiscount" placeholder="服务费折扣比例"></el-input>
    </el-form-item>
    <el-form-item label="总金额折扣比例" prop="totalDiscount">
      <el-input v-model="dataForm.totalDiscount" placeholder="总金额折扣比例"></el-input>
    </el-form-item>
    <el-form-item label="原始服务费折扣金额保留四位小数(单位：元)" prop="oldDiscountServiceAmount">
      <el-input v-model="dataForm.oldDiscountServiceAmount" placeholder="原始服务费折扣金额保留四位小数(单位：元)"></el-input>
    </el-form-item>
    <el-form-item label="服务费折扣金额(单位：元)" prop="discountServiceAmount">
      <el-input v-model="dataForm.discountServiceAmount" placeholder="服务费折扣金额(单位：元)"></el-input>
    </el-form-item>
    <el-form-item label="原始充电费折扣金额保留四位小数(单位：元)" prop="oldDiscountChargerAmount">
      <el-input v-model="dataForm.oldDiscountChargerAmount" placeholder="原始充电费折扣金额保留四位小数(单位：元)"></el-input>
    </el-form-item>
    <el-form-item label="充电费折扣金额(单位：元)" prop="discountChargerAmount">
      <el-input v-model="dataForm.discountChargerAmount" placeholder="充电费折扣金额(单位：元)"></el-input>
    </el-form-item>
    <el-form-item label="原始充电订单总金额折扣,保留四位小数(单位：元)" prop="oldDiscountOrderAmount">
      <el-input v-model="dataForm.oldDiscountOrderAmount" placeholder="原始充电订单总金额折扣,保留四位小数(单位：元)"></el-input>
    </el-form-item>
    <el-form-item label="充电订单总金额折扣(单位：元)" prop="discountOrderAmount">
      <el-input v-model="dataForm.discountOrderAmount" placeholder="充电订单总金额折扣(单位：元)"></el-input>
    </el-form-item>
    <el-form-item label="抵扣规则主表ID" prop="deductionMasterId">
      <el-input v-model="dataForm.deductionMasterId" placeholder="抵扣规则主表ID"></el-input>
    </el-form-item>
    <el-form-item label="抵扣规则名称" prop="deductionName">
      <el-input v-model="dataForm.deductionName" placeholder="抵扣规则名称"></el-input>
    </el-form-item>
    <el-form-item label="抵扣规则明细ID" prop="deductionId">
      <el-input v-model="dataForm.deductionId" placeholder="抵扣规则明细ID"></el-input>
    </el-form-item>
    <el-form-item label="起始抵扣金额" prop="deductionStartAmount">
      <el-input v-model="dataForm.deductionStartAmount" placeholder="起始抵扣金额"></el-input>
    </el-form-item>
    <el-form-item label="抵扣金额(单位：元)" prop="deductionAmount">
      <el-input v-model="dataForm.deductionAmount" placeholder="抵扣金额(单位：元)"></el-input>
    </el-form-item>
    <el-form-item label="抵扣订单金额(单位：元)" prop="deductionOrderAmount">
      <el-input v-model="dataForm.deductionOrderAmount" placeholder="抵扣订单金额(单位：元)"></el-input>
    </el-form-item>
    <el-form-item label="抵扣开始时间" prop="deductionStartTime">
      <el-input v-model="dataForm.deductionStartTime" placeholder="抵扣开始时间"></el-input>
    </el-form-item>
    <el-form-item label="抵扣结束时间" prop="deductionEndTime">
      <el-input v-model="dataForm.deductionEndTime" placeholder="抵扣结束时间"></el-input>
    </el-form-item>
    <el-form-item label="优惠类型：0无优惠、1明细折扣、2总价折扣、3满减、4混合优惠(折扣与满减一起使用)、5优惠卷" prop="discountFlag">
      <el-input v-model="dataForm.discountFlag" placeholder="优惠类型：0无优惠、1明细折扣、2总价折扣、3满减、4混合优惠(折扣与满减一起使用)、5优惠卷"></el-input>
    </el-form-item>
    <el-form-item label="卡用户手机号" prop="cardName">
      <el-input v-model="dataForm.cardName" placeholder="卡用户手机号"></el-input>
    </el-form-item>
    <el-form-item label="第三方运营商ID" prop="operatorId">
      <el-input v-model="dataForm.operatorId" placeholder="第三方运营商ID"></el-input>
    </el-form-item>
    <el-form-item label="第三方运营商名称" prop="operatorName">
      <el-input v-model="dataForm.operatorName" placeholder="第三方运营商名称"></el-input>
    </el-form-item>
    <el-form-item label="结算时间" prop="settlementTime">
      <el-input v-model="dataForm.settlementTime" placeholder="结算时间"></el-input>
    </el-form-item>
    <el-form-item label="桩上报的卡余额" prop="pileCardBalance">
      <el-input v-model="dataForm.pileCardBalance" placeholder="桩上报的卡余额"></el-input>
    </el-form-item>
    <el-form-item label="设备厂商ID" prop="vendorId">
      <el-input v-model="dataForm.vendorId" placeholder="设备厂商ID"></el-input>
    </el-form-item>
    <el-form-item label="设备厂商名称" prop="vendorName">
      <el-input v-model="dataForm.vendorName" placeholder="设备厂商名称"></el-input>
    </el-form-item>
    <el-form-item label="故障类型说明" prop="stopReason">
      <el-input v-model="dataForm.stopReason" placeholder="故障类型说明"></el-input>
    </el-form-item>
    <el-form-item label="结束状态：0正常结束、1故障结束" prop="stopStatus">
      <el-input v-model="dataForm.stopStatus" placeholder="结束状态：0正常结束、1故障结束"></el-input>
    </el-form-item>
    <el-form-item label="结束详情" prop="stopDetails">
      <el-input v-model="dataForm.stopDetails" placeholder="结束详情"></el-input>
    </el-form-item>
    <el-form-item label="停止状态说明" prop="stopStatusDesc">
      <el-input v-model="dataForm.stopStatusDesc" placeholder="停止状态说明"></el-input>
    </el-form-item>
    <el-form-item label="互联互通运营商设备ID" prop="connectorId">
      <el-input v-model="dataForm.connectorId" placeholder="互联互通运营商设备ID"></el-input>
    </el-form-item>
    <el-form-item label="用户优惠卷ID" prop="userCouponId">
      <el-input v-model="dataForm.userCouponId" placeholder="用户优惠卷ID"></el-input>
    </el-form-item>
    <el-form-item label="抵扣券别名" prop="userCouponName">
      <el-input v-model="dataForm.userCouponName" placeholder="抵扣券别名"></el-input>
    </el-form-item>
    <el-form-item label="抵扣金额" prop="userCouponAmount">
      <el-input v-model="dataForm.userCouponAmount" placeholder="抵扣金额"></el-input>
    </el-form-item>
    <el-form-item label="起始抵扣金额" prop="userCouponInitialAmount">
      <el-input v-model="dataForm.userCouponInitialAmount" placeholder="起始抵扣金额"></el-input>
    </el-form-item>
    <el-form-item label="实际抵扣金额" prop="actualCouponAmount">
      <el-input v-model="dataForm.actualCouponAmount" placeholder="实际抵扣金额"></el-input>
    </el-form-item>
    <el-form-item label="桩上报的原始服务费" prop="oldServiceFee">
      <el-input v-model="dataForm.oldServiceFee" placeholder="桩上报的原始服务费"></el-input>
    </el-form-item>
    <el-form-item label="里程数" prop="odometer">
      <el-input v-model="dataForm.odometer" placeholder="里程数"></el-input>
    </el-form-item>
    <el-form-item label="车牌号码" prop="cartNo">
      <el-input v-model="dataForm.cartNo" placeholder="车牌号码"></el-input>
    </el-form-item>
    <el-form-item label="停车系统推送标记：0未推送，1已推送" prop="parkFlag">
      <el-input v-model="dataForm.parkFlag" placeholder="停车系统推送标记：0未推送，1已推送"></el-input>
    </el-form-item>
    <el-form-item label="是否删除: :0正常、1删除" prop="delFlag">
      <el-input v-model="dataForm.delFlag" placeholder="是否删除: :0正常、1删除"></el-input>
    </el-form-item>
    <el-form-item label="备注" prop="remark">
      <el-input v-model="dataForm.remark" placeholder="备注"></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          id: 0,
          uuid: '',
          interconnectionFlag: '',
          longOrderNo: '',
          orderNo: '',
          orderName: '',
          isOver: '',
          receiveFlag: '',
          userId: '',
          userName: '',
          userShortId: '',
          protocolType: '',
          vin: '',
          userType: '',
          payUuid: '',
          agentId: '',
          agentName: '',
          companyFlag: '',
          companyId: '',
          companyName: '',
          orderType: '',
          orderFlag: '',
          stopCode: '',
          payStatus: '',
          startTime: '',
          endTime: '',
          chargingType: '',
          chargingNumber: '',
          chargingMark: '',
          startSoc: '',
          endSoc: '',
          totalElec: '',
          totalTime: '',
          startMeter: '',
          endMeter: '',
          startAmount: '',
          endAmount: '',
          chargingFee: '',
          serviceFee: '',
          totalAmount: '',
          actualAmount: '',
          serviceId: '',
          invoiceFlag: '',
          pileId: '',
          pileSn: '',
          pileName: '',
          communicationSn: '',
          driveNo: '',
          gunId: '',
          gunNo: '',
          tcuSn: '',
          gunType: '',
          stationId: '',
          stationName: '',
          parkingFeeFlag: '',
          cardId: '',
          createTime: '',
          createBy: '',
          updateTime: '',
          updateBy: '',
          cardSn: '',
          cardType: '',
          branchId: '',
          branchName: '',
          cardBalance: '',
          mergeFlag: '',
          mergeOrderFlag: '',
          masterGunFlag: '',
          discountId: '',
          discountName: '',
          elecDiscount: '',
          serviceDiscount: '',
          totalDiscount: '',
          oldDiscountServiceAmount: '',
          discountServiceAmount: '',
          oldDiscountChargerAmount: '',
          discountChargerAmount: '',
          oldDiscountOrderAmount: '',
          discountOrderAmount: '',
          deductionMasterId: '',
          deductionName: '',
          deductionId: '',
          deductionStartAmount: '',
          deductionAmount: '',
          deductionOrderAmount: '',
          deductionStartTime: '',
          deductionEndTime: '',
          discountFlag: '',
          cardName: '',
          operatorId: '',
          operatorName: '',
          settlementTime: '',
          pileCardBalance: '',
          vendorId: '',
          vendorName: '',
          stopReason: '',
          stopStatus: '',
          stopDetails: '',
          stopStatusDesc: '',
          connectorId: '',
          userCouponId: '',
          userCouponName: '',
          userCouponAmount: '',
          userCouponInitialAmount: '',
          actualCouponAmount: '',
          oldServiceFee: '',
          odometer: '',
          cartNo: '',
          parkFlag: '',
          delFlag: '',
          remark: ''
        },
        dataRule: {
          uuid: [
            { required: true, message: 'uuid UUID不能为空', trigger: 'blur' }
          ],
          interconnectionFlag: [
            { required: true, message: '是否我方用户在第三方充电的订单：0系统桩订单、1互联互通桩订单不能为空', trigger: 'blur' }
          ],
          longOrderNo: [
            { required: true, message: '长订单号 - 互联互通订单号不能为空', trigger: 'blur' }
          ],
          orderNo: [
            { required: true, message: '订单编号不能为空', trigger: 'blur' }
          ],
          orderName: [
            { required: true, message: '订单名称不能为空', trigger: 'blur' }
          ],
          isOver: [
            { required: true, message: '订单是否完成：；0未完成、1已完成、2异常订单不能为空', trigger: 'blur' }
          ],
          receiveFlag: [
            { required: true, message: '接收充电桩上送数据标志：0未接收、1已接收、2待上报账单不能为空', trigger: 'blur' }
          ],
          userId: [
            { required: true, message: '用户ID不能为空', trigger: 'blur' }
          ],
          userName: [
            { required: true, message: '用户名不能为空', trigger: 'blur' }
          ],
          userShortId: [
            { required: true, message: '用户16位标示号不能为空', trigger: 'blur' }
          ],
          protocolType: [
            { required: true, message: '设备协议类型:0新协议、1旧协议不能为空', trigger: 'blur' }
          ],
          vin: [
            { required: true, message: 'Vin，17位字符串不能为空', trigger: 'blur' }
          ],
          userType: [
            { required: true, message: '用户账户类型： 0APP、1卡、2VIN、3、企业用户、4微信公众号、5微信小程序、6互联互通不能为空', trigger: 'blur' }
          ],
          payUuid: [
            { required: true, message: '运营商绑定的支付通道ID不能为空', trigger: 'blur' }
          ],
          agentId: [
            { required: true, message: '运营商ID不能为空', trigger: 'blur' }
          ],
          agentName: [
            { required: true, message: '运营商名称不能为空', trigger: 'blur' }
          ],
          companyFlag: [
            { required: true, message: '是否企业员工订单： 0普通用户、1企业用户可使用企业资金池、2平台订单(互联互通订单)不能为空', trigger: 'blur' }
          ],
          companyId: [
            { required: true, message: '企业ID不能为空', trigger: 'blur' }
          ],
          companyName: [
            { required: true, message: '企业名称不能为空', trigger: 'blur' }
          ],
          orderType: [
            { required: true, message: '订单类型：1刷卡在线充电、2移动app充电、3vin充电、4刷卡离线充电、5微信公众号充电、6微信小程序充电、7互联互通充电不能为空', trigger: 'blur' }
          ],
          orderFlag: [
            { required: true, message: '订单标志： 0平台订单、1第三方平台订单不能为空', trigger: 'blur' }
          ],
          stopCode: [
            { required: true, message: '停机控制码 - 针对充电订单进行停车充电时不能为空', trigger: 'blur' }
          ],
          payStatus: [
            { required: true, message: '支付状态： :0未支付、1已支付不能为空', trigger: 'blur' }
          ],
          startTime: [
            { required: true, message: '开始时间不能为空', trigger: 'blur' }
          ],
          endTime: [
            { required: true, message: '结束时间不能为空', trigger: 'blur' }
          ],
          chargingType: [
            { required: true, message: '充电方式:01：电量控制充电；02：时间控制充电；03：金额控制充电；04：自动充满05：定时启动充电不能为空', trigger: 'blur' }
          ],
          chargingNumber: [
            { required: true, message: '用户选择充电量 度、千瓦时/充电金额/单位：分钟,配合charging_type使用不能为空', trigger: 'blur' }
          ],
          chargingMark: [
            { required: true, message: '充电标示号，充电桩启动充电成功后返回的不能为空', trigger: 'blur' }
          ],
          startSoc: [
            { required: true, message: '起始SOC 百分比不能为空', trigger: 'blur' }
          ],
          endSoc: [
            { required: true, message: '结束SOC 百分比不能为空', trigger: 'blur' }
          ],
          totalElec: [
            { required: true, message: '充电总电量不能为空', trigger: 'blur' }
          ],
          totalTime: [
            { required: true, message: '充电桩上传的充电时长：秒不能为空', trigger: 'blur' }
          ],
          startMeter: [
            { required: true, message: '起始电表值不能为空', trigger: 'blur' }
          ],
          endMeter: [
            { required: true, message: '结束电表值不能为空', trigger: 'blur' }
          ],
          startAmount: [
            { required: true, message: '起始余额 单位：元不能为空', trigger: 'blur' }
          ],
          endAmount: [
            { required: true, message: '结束余额 单位：元不能为空', trigger: 'blur' }
          ],
          chargingFee: [
            { required: true, message: '充电费 单位：元不能为空', trigger: 'blur' }
          ],
          serviceFee: [
            { required: true, message: '服务费 单位：元不能为空', trigger: 'blur' }
          ],
          totalAmount: [
            { required: true, message: '总费用 单位：元不能为空', trigger: 'blur' }
          ],
          actualAmount: [
            { required: true, message: '实收费用： 单位：元不能为空', trigger: 'blur' }
          ],
          serviceId: [
            { required: true, message: '服务费ID不能为空', trigger: 'blur' }
          ],
          invoiceFlag: [
            { required: true, message: '是否开发票： 0未开发票、1开具发票不能为空', trigger: 'blur' }
          ],
          pileId: [
            { required: true, message: '充电桩ID不能为空', trigger: 'blur' }
          ],
          pileSn: [
            { required: true, message: '充电桩出厂编号不能为空', trigger: 'blur' }
          ],
          pileName: [
            { required: true, message: '充电桩名称不能为空', trigger: 'blur' }
          ],
          communicationSn: [
            { required: true, message: '通讯编号，默认14位不能为空', trigger: 'blur' }
          ],
          driveNo: [
            { required: true, message: '充电桩设备编号不能为空', trigger: 'blur' }
          ],
          gunId: [
            { required: true, message: '充电枪ID不能为空', trigger: 'blur' }
          ],
          gunNo: [
            { required: true, message: '充电枪编号不能为空', trigger: 'blur' }
          ],
          tcuSn: [
            { required: true, message: 'TCU编号不能为空', trigger: 'blur' }
          ],
          gunType: [
            { required: true, message: '充电枪类型 0交流、1直流、2交直流一体不能为空', trigger: 'blur' }
          ],
          stationId: [
            { required: true, message: '充电桩归属电站ID不能为空', trigger: 'blur' }
          ],
          stationName: [
            { required: true, message: '充电站名称不能为空', trigger: 'blur' }
          ],
          parkingFeeFlag: [
            { required: true, message: '是否收取停车费: 0免费、1收费不能为空', trigger: 'blur' }
          ],
          cardId: [
            { required: true, message: '卡ID不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建时间 创建时间不能为空', trigger: 'blur' }
          ],
          createBy: [
            { required: true, message: '创建人 创建人不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '最后更新时间 最后更新时间不能为空', trigger: 'blur' }
          ],
          updateBy: [
            { required: true, message: '最后更新人 最后更新人不能为空', trigger: 'blur' }
          ],
          cardSn: [
            { required: true, message: '卡号不能为空', trigger: 'blur' }
          ],
          cardType: [
            { required: true, message: '卡类型：0用户卡、1员工卡、2管理卡不能为空', trigger: 'blur' }
          ],
          branchId: [
            { required: true, message: '网点ID不能为空', trigger: 'blur' }
          ],
          branchName: [
            { required: true, message: '网点名称不能为空', trigger: 'blur' }
          ],
          cardBalance: [
            { required: true, message: '充电前卡余额(平台记录的卡余额)不能为空', trigger: 'blur' }
          ],
          mergeFlag: [
            { required: true, message: '是否并行充电：0常规充电、1并机充电不能为空', trigger: 'blur' }
          ],
          mergeOrderFlag: [
            { required: true, message: '并机汇总订单标记：0汇总订单(需要扣款)、1分机订单不能为空', trigger: 'blur' }
          ],
          masterGunFlag: [
            { required: true, message: '并机主枪标记：0主枪订单、1从枪订单不能为空', trigger: 'blur' }
          ],
          discountId: [
            { required: true, message: '折扣规则ID不能为空', trigger: 'blur' }
          ],
          discountName: [
            { required: true, message: '折扣规则名称不能为空', trigger: 'blur' }
          ],
          elecDiscount: [
            { required: true, message: '充电费折扣比例不能为空', trigger: 'blur' }
          ],
          serviceDiscount: [
            { required: true, message: '服务费折扣比例不能为空', trigger: 'blur' }
          ],
          totalDiscount: [
            { required: true, message: '总金额折扣比例不能为空', trigger: 'blur' }
          ],
          oldDiscountServiceAmount: [
            { required: true, message: '原始服务费折扣金额保留四位小数(单位：元)不能为空', trigger: 'blur' }
          ],
          discountServiceAmount: [
            { required: true, message: '服务费折扣金额(单位：元)不能为空', trigger: 'blur' }
          ],
          oldDiscountChargerAmount: [
            { required: true, message: '原始充电费折扣金额保留四位小数(单位：元)不能为空', trigger: 'blur' }
          ],
          discountChargerAmount: [
            { required: true, message: '充电费折扣金额(单位：元)不能为空', trigger: 'blur' }
          ],
          oldDiscountOrderAmount: [
            { required: true, message: '原始充电订单总金额折扣,保留四位小数(单位：元)不能为空', trigger: 'blur' }
          ],
          discountOrderAmount: [
            { required: true, message: '充电订单总金额折扣(单位：元)不能为空', trigger: 'blur' }
          ],
          deductionMasterId: [
            { required: true, message: '抵扣规则主表ID不能为空', trigger: 'blur' }
          ],
          deductionName: [
            { required: true, message: '抵扣规则名称不能为空', trigger: 'blur' }
          ],
          deductionId: [
            { required: true, message: '抵扣规则明细ID不能为空', trigger: 'blur' }
          ],
          deductionStartAmount: [
            { required: true, message: '起始抵扣金额不能为空', trigger: 'blur' }
          ],
          deductionAmount: [
            { required: true, message: '抵扣金额(单位：元)不能为空', trigger: 'blur' }
          ],
          deductionOrderAmount: [
            { required: true, message: '抵扣订单金额(单位：元)不能为空', trigger: 'blur' }
          ],
          deductionStartTime: [
            { required: true, message: '抵扣开始时间不能为空', trigger: 'blur' }
          ],
          deductionEndTime: [
            { required: true, message: '抵扣结束时间不能为空', trigger: 'blur' }
          ],
          discountFlag: [
            { required: true, message: '优惠类型：0无优惠、1明细折扣、2总价折扣、3满减、4混合优惠(折扣与满减一起使用)、5优惠卷不能为空', trigger: 'blur' }
          ],
          cardName: [
            { required: true, message: '卡用户手机号不能为空', trigger: 'blur' }
          ],
          operatorId: [
            { required: true, message: '第三方运营商ID不能为空', trigger: 'blur' }
          ],
          operatorName: [
            { required: true, message: '第三方运营商名称不能为空', trigger: 'blur' }
          ],
          settlementTime: [
            { required: true, message: '结算时间不能为空', trigger: 'blur' }
          ],
          pileCardBalance: [
            { required: true, message: '桩上报的卡余额不能为空', trigger: 'blur' }
          ],
          vendorId: [
            { required: true, message: '设备厂商ID不能为空', trigger: 'blur' }
          ],
          vendorName: [
            { required: true, message: '设备厂商名称不能为空', trigger: 'blur' }
          ],
          stopReason: [
            { required: true, message: '故障类型说明不能为空', trigger: 'blur' }
          ],
          stopStatus: [
            { required: true, message: '结束状态：0正常结束、1故障结束不能为空', trigger: 'blur' }
          ],
          stopDetails: [
            { required: true, message: '结束详情不能为空', trigger: 'blur' }
          ],
          stopStatusDesc: [
            { required: true, message: '停止状态说明不能为空', trigger: 'blur' }
          ],
          connectorId: [
            { required: true, message: '互联互通运营商设备ID不能为空', trigger: 'blur' }
          ],
          userCouponId: [
            { required: true, message: '用户优惠卷ID不能为空', trigger: 'blur' }
          ],
          userCouponName: [
            { required: true, message: '抵扣券别名不能为空', trigger: 'blur' }
          ],
          userCouponAmount: [
            { required: true, message: '抵扣金额不能为空', trigger: 'blur' }
          ],
          userCouponInitialAmount: [
            { required: true, message: '起始抵扣金额不能为空', trigger: 'blur' }
          ],
          actualCouponAmount: [
            { required: true, message: '实际抵扣金额不能为空', trigger: 'blur' }
          ],
          oldServiceFee: [
            { required: true, message: '桩上报的原始服务费不能为空', trigger: 'blur' }
          ],
          odometer: [
            { required: true, message: '里程数不能为空', trigger: 'blur' }
          ],
          cartNo: [
            { required: true, message: '车牌号码不能为空', trigger: 'blur' }
          ],
          parkFlag: [
            { required: true, message: '停车系统推送标记：0未推送，1已推送不能为空', trigger: 'blur' }
          ],
          delFlag: [
            { required: true, message: '是否删除: :0正常、1删除不能为空', trigger: 'blur' }
          ],
          remark: [
            { required: true, message: '备注不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/generator/tordercharging/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.uuid = data.tOrderCharging.uuid
                this.dataForm.interconnectionFlag = data.tOrderCharging.interconnectionFlag
                this.dataForm.longOrderNo = data.tOrderCharging.longOrderNo
                this.dataForm.orderNo = data.tOrderCharging.orderNo
                this.dataForm.orderName = data.tOrderCharging.orderName
                this.dataForm.isOver = data.tOrderCharging.isOver
                this.dataForm.receiveFlag = data.tOrderCharging.receiveFlag
                this.dataForm.userId = data.tOrderCharging.userId
                this.dataForm.userName = data.tOrderCharging.userName
                this.dataForm.userShortId = data.tOrderCharging.userShortId
                this.dataForm.protocolType = data.tOrderCharging.protocolType
                this.dataForm.vin = data.tOrderCharging.vin
                this.dataForm.userType = data.tOrderCharging.userType
                this.dataForm.payUuid = data.tOrderCharging.payUuid
                this.dataForm.agentId = data.tOrderCharging.agentId
                this.dataForm.agentName = data.tOrderCharging.agentName
                this.dataForm.companyFlag = data.tOrderCharging.companyFlag
                this.dataForm.companyId = data.tOrderCharging.companyId
                this.dataForm.companyName = data.tOrderCharging.companyName
                this.dataForm.orderType = data.tOrderCharging.orderType
                this.dataForm.orderFlag = data.tOrderCharging.orderFlag
                this.dataForm.stopCode = data.tOrderCharging.stopCode
                this.dataForm.payStatus = data.tOrderCharging.payStatus
                this.dataForm.startTime = data.tOrderCharging.startTime
                this.dataForm.endTime = data.tOrderCharging.endTime
                this.dataForm.chargingType = data.tOrderCharging.chargingType
                this.dataForm.chargingNumber = data.tOrderCharging.chargingNumber
                this.dataForm.chargingMark = data.tOrderCharging.chargingMark
                this.dataForm.startSoc = data.tOrderCharging.startSoc
                this.dataForm.endSoc = data.tOrderCharging.endSoc
                this.dataForm.totalElec = data.tOrderCharging.totalElec
                this.dataForm.totalTime = data.tOrderCharging.totalTime
                this.dataForm.startMeter = data.tOrderCharging.startMeter
                this.dataForm.endMeter = data.tOrderCharging.endMeter
                this.dataForm.startAmount = data.tOrderCharging.startAmount
                this.dataForm.endAmount = data.tOrderCharging.endAmount
                this.dataForm.chargingFee = data.tOrderCharging.chargingFee
                this.dataForm.serviceFee = data.tOrderCharging.serviceFee
                this.dataForm.totalAmount = data.tOrderCharging.totalAmount
                this.dataForm.actualAmount = data.tOrderCharging.actualAmount
                this.dataForm.serviceId = data.tOrderCharging.serviceId
                this.dataForm.invoiceFlag = data.tOrderCharging.invoiceFlag
                this.dataForm.pileId = data.tOrderCharging.pileId
                this.dataForm.pileSn = data.tOrderCharging.pileSn
                this.dataForm.pileName = data.tOrderCharging.pileName
                this.dataForm.communicationSn = data.tOrderCharging.communicationSn
                this.dataForm.driveNo = data.tOrderCharging.driveNo
                this.dataForm.gunId = data.tOrderCharging.gunId
                this.dataForm.gunNo = data.tOrderCharging.gunNo
                this.dataForm.tcuSn = data.tOrderCharging.tcuSn
                this.dataForm.gunType = data.tOrderCharging.gunType
                this.dataForm.stationId = data.tOrderCharging.stationId
                this.dataForm.stationName = data.tOrderCharging.stationName
                this.dataForm.parkingFeeFlag = data.tOrderCharging.parkingFeeFlag
                this.dataForm.cardId = data.tOrderCharging.cardId
                this.dataForm.createTime = data.tOrderCharging.createTime
                this.dataForm.createBy = data.tOrderCharging.createBy
                this.dataForm.updateTime = data.tOrderCharging.updateTime
                this.dataForm.updateBy = data.tOrderCharging.updateBy
                this.dataForm.cardSn = data.tOrderCharging.cardSn
                this.dataForm.cardType = data.tOrderCharging.cardType
                this.dataForm.branchId = data.tOrderCharging.branchId
                this.dataForm.branchName = data.tOrderCharging.branchName
                this.dataForm.cardBalance = data.tOrderCharging.cardBalance
                this.dataForm.mergeFlag = data.tOrderCharging.mergeFlag
                this.dataForm.mergeOrderFlag = data.tOrderCharging.mergeOrderFlag
                this.dataForm.masterGunFlag = data.tOrderCharging.masterGunFlag
                this.dataForm.discountId = data.tOrderCharging.discountId
                this.dataForm.discountName = data.tOrderCharging.discountName
                this.dataForm.elecDiscount = data.tOrderCharging.elecDiscount
                this.dataForm.serviceDiscount = data.tOrderCharging.serviceDiscount
                this.dataForm.totalDiscount = data.tOrderCharging.totalDiscount
                this.dataForm.oldDiscountServiceAmount = data.tOrderCharging.oldDiscountServiceAmount
                this.dataForm.discountServiceAmount = data.tOrderCharging.discountServiceAmount
                this.dataForm.oldDiscountChargerAmount = data.tOrderCharging.oldDiscountChargerAmount
                this.dataForm.discountChargerAmount = data.tOrderCharging.discountChargerAmount
                this.dataForm.oldDiscountOrderAmount = data.tOrderCharging.oldDiscountOrderAmount
                this.dataForm.discountOrderAmount = data.tOrderCharging.discountOrderAmount
                this.dataForm.deductionMasterId = data.tOrderCharging.deductionMasterId
                this.dataForm.deductionName = data.tOrderCharging.deductionName
                this.dataForm.deductionId = data.tOrderCharging.deductionId
                this.dataForm.deductionStartAmount = data.tOrderCharging.deductionStartAmount
                this.dataForm.deductionAmount = data.tOrderCharging.deductionAmount
                this.dataForm.deductionOrderAmount = data.tOrderCharging.deductionOrderAmount
                this.dataForm.deductionStartTime = data.tOrderCharging.deductionStartTime
                this.dataForm.deductionEndTime = data.tOrderCharging.deductionEndTime
                this.dataForm.discountFlag = data.tOrderCharging.discountFlag
                this.dataForm.cardName = data.tOrderCharging.cardName
                this.dataForm.operatorId = data.tOrderCharging.operatorId
                this.dataForm.operatorName = data.tOrderCharging.operatorName
                this.dataForm.settlementTime = data.tOrderCharging.settlementTime
                this.dataForm.pileCardBalance = data.tOrderCharging.pileCardBalance
                this.dataForm.vendorId = data.tOrderCharging.vendorId
                this.dataForm.vendorName = data.tOrderCharging.vendorName
                this.dataForm.stopReason = data.tOrderCharging.stopReason
                this.dataForm.stopStatus = data.tOrderCharging.stopStatus
                this.dataForm.stopDetails = data.tOrderCharging.stopDetails
                this.dataForm.stopStatusDesc = data.tOrderCharging.stopStatusDesc
                this.dataForm.connectorId = data.tOrderCharging.connectorId
                this.dataForm.userCouponId = data.tOrderCharging.userCouponId
                this.dataForm.userCouponName = data.tOrderCharging.userCouponName
                this.dataForm.userCouponAmount = data.tOrderCharging.userCouponAmount
                this.dataForm.userCouponInitialAmount = data.tOrderCharging.userCouponInitialAmount
                this.dataForm.actualCouponAmount = data.tOrderCharging.actualCouponAmount
                this.dataForm.oldServiceFee = data.tOrderCharging.oldServiceFee
                this.dataForm.odometer = data.tOrderCharging.odometer
                this.dataForm.cartNo = data.tOrderCharging.cartNo
                this.dataForm.parkFlag = data.tOrderCharging.parkFlag
                this.dataForm.delFlag = data.tOrderCharging.delFlag
                this.dataForm.remark = data.tOrderCharging.remark
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/generator/tordercharging/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'uuid': this.dataForm.uuid,
                'interconnectionFlag': this.dataForm.interconnectionFlag,
                'longOrderNo': this.dataForm.longOrderNo,
                'orderNo': this.dataForm.orderNo,
                'orderName': this.dataForm.orderName,
                'isOver': this.dataForm.isOver,
                'receiveFlag': this.dataForm.receiveFlag,
                'userId': this.dataForm.userId,
                'userName': this.dataForm.userName,
                'userShortId': this.dataForm.userShortId,
                'protocolType': this.dataForm.protocolType,
                'vin': this.dataForm.vin,
                'userType': this.dataForm.userType,
                'payUuid': this.dataForm.payUuid,
                'agentId': this.dataForm.agentId,
                'agentName': this.dataForm.agentName,
                'companyFlag': this.dataForm.companyFlag,
                'companyId': this.dataForm.companyId,
                'companyName': this.dataForm.companyName,
                'orderType': this.dataForm.orderType,
                'orderFlag': this.dataForm.orderFlag,
                'stopCode': this.dataForm.stopCode,
                'payStatus': this.dataForm.payStatus,
                'startTime': this.dataForm.startTime,
                'endTime': this.dataForm.endTime,
                'chargingType': this.dataForm.chargingType,
                'chargingNumber': this.dataForm.chargingNumber,
                'chargingMark': this.dataForm.chargingMark,
                'startSoc': this.dataForm.startSoc,
                'endSoc': this.dataForm.endSoc,
                'totalElec': this.dataForm.totalElec,
                'totalTime': this.dataForm.totalTime,
                'startMeter': this.dataForm.startMeter,
                'endMeter': this.dataForm.endMeter,
                'startAmount': this.dataForm.startAmount,
                'endAmount': this.dataForm.endAmount,
                'chargingFee': this.dataForm.chargingFee,
                'serviceFee': this.dataForm.serviceFee,
                'totalAmount': this.dataForm.totalAmount,
                'actualAmount': this.dataForm.actualAmount,
                'serviceId': this.dataForm.serviceId,
                'invoiceFlag': this.dataForm.invoiceFlag,
                'pileId': this.dataForm.pileId,
                'pileSn': this.dataForm.pileSn,
                'pileName': this.dataForm.pileName,
                'communicationSn': this.dataForm.communicationSn,
                'driveNo': this.dataForm.driveNo,
                'gunId': this.dataForm.gunId,
                'gunNo': this.dataForm.gunNo,
                'tcuSn': this.dataForm.tcuSn,
                'gunType': this.dataForm.gunType,
                'stationId': this.dataForm.stationId,
                'stationName': this.dataForm.stationName,
                'parkingFeeFlag': this.dataForm.parkingFeeFlag,
                'cardId': this.dataForm.cardId,
                'createTime': this.dataForm.createTime,
                'createBy': this.dataForm.createBy,
                'updateTime': this.dataForm.updateTime,
                'updateBy': this.dataForm.updateBy,
                'cardSn': this.dataForm.cardSn,
                'cardType': this.dataForm.cardType,
                'branchId': this.dataForm.branchId,
                'branchName': this.dataForm.branchName,
                'cardBalance': this.dataForm.cardBalance,
                'mergeFlag': this.dataForm.mergeFlag,
                'mergeOrderFlag': this.dataForm.mergeOrderFlag,
                'masterGunFlag': this.dataForm.masterGunFlag,
                'discountId': this.dataForm.discountId,
                'discountName': this.dataForm.discountName,
                'elecDiscount': this.dataForm.elecDiscount,
                'serviceDiscount': this.dataForm.serviceDiscount,
                'totalDiscount': this.dataForm.totalDiscount,
                'oldDiscountServiceAmount': this.dataForm.oldDiscountServiceAmount,
                'discountServiceAmount': this.dataForm.discountServiceAmount,
                'oldDiscountChargerAmount': this.dataForm.oldDiscountChargerAmount,
                'discountChargerAmount': this.dataForm.discountChargerAmount,
                'oldDiscountOrderAmount': this.dataForm.oldDiscountOrderAmount,
                'discountOrderAmount': this.dataForm.discountOrderAmount,
                'deductionMasterId': this.dataForm.deductionMasterId,
                'deductionName': this.dataForm.deductionName,
                'deductionId': this.dataForm.deductionId,
                'deductionStartAmount': this.dataForm.deductionStartAmount,
                'deductionAmount': this.dataForm.deductionAmount,
                'deductionOrderAmount': this.dataForm.deductionOrderAmount,
                'deductionStartTime': this.dataForm.deductionStartTime,
                'deductionEndTime': this.dataForm.deductionEndTime,
                'discountFlag': this.dataForm.discountFlag,
                'cardName': this.dataForm.cardName,
                'operatorId': this.dataForm.operatorId,
                'operatorName': this.dataForm.operatorName,
                'settlementTime': this.dataForm.settlementTime,
                'pileCardBalance': this.dataForm.pileCardBalance,
                'vendorId': this.dataForm.vendorId,
                'vendorName': this.dataForm.vendorName,
                'stopReason': this.dataForm.stopReason,
                'stopStatus': this.dataForm.stopStatus,
                'stopDetails': this.dataForm.stopDetails,
                'stopStatusDesc': this.dataForm.stopStatusDesc,
                'connectorId': this.dataForm.connectorId,
                'userCouponId': this.dataForm.userCouponId,
                'userCouponName': this.dataForm.userCouponName,
                'userCouponAmount': this.dataForm.userCouponAmount,
                'userCouponInitialAmount': this.dataForm.userCouponInitialAmount,
                'actualCouponAmount': this.dataForm.actualCouponAmount,
                'oldServiceFee': this.dataForm.oldServiceFee,
                'odometer': this.dataForm.odometer,
                'cartNo': this.dataForm.cartNo,
                'parkFlag': this.dataForm.parkFlag,
                'delFlag': this.dataForm.delFlag,
                'remark': this.dataForm.remark
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
