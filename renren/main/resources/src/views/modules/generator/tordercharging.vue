<template>
  <div class="mod-config">
    <el-form :inline="true" :model="dataForm" @keyup.enter.native="getDataList()">
      <el-form-item>
        <el-input v-model="dataForm.key" placeholder="参数名" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="getDataList()">查询</el-button>
        <el-button v-if="isAuth('generator:tordercharging:save')" type="primary" @click="addOrUpdateHandle()">新增</el-button>
        <el-button v-if="isAuth('generator:tordercharging:delete')" type="danger" @click="deleteHandle()" :disabled="dataListSelections.length <= 0">批量删除</el-button>
      </el-form-item>
    </el-form>
    <el-table
      :data="dataList"
      border
      v-loading="dataListLoading"
      @selection-change="selectionChangeHandle"
      style="width: 100%;">
      <el-table-column
        type="selection"
        header-align="center"
        align="center"
        width="50">
      </el-table-column>
      <el-table-column
        prop="id"
        header-align="center"
        align="center"
        label="id id">
      </el-table-column>
      <el-table-column
        prop="uuid"
        header-align="center"
        align="center"
        label="uuid UUID">
      </el-table-column>
      <el-table-column
        prop="interconnectionFlag"
        header-align="center"
        align="center"
        label="是否我方用户在第三方充电的订单：0系统桩订单、1互联互通桩订单">
      </el-table-column>
      <el-table-column
        prop="longOrderNo"
        header-align="center"
        align="center"
        label="长订单号 - 互联互通订单号">
      </el-table-column>
      <el-table-column
        prop="orderNo"
        header-align="center"
        align="center"
        label="订单编号">
      </el-table-column>
      <el-table-column
        prop="orderName"
        header-align="center"
        align="center"
        label="订单名称">
      </el-table-column>
      <el-table-column
        prop="isOver"
        header-align="center"
        align="center"
        label="订单是否完成：；0未完成、1已完成、2异常订单">
      </el-table-column>
      <el-table-column
        prop="receiveFlag"
        header-align="center"
        align="center"
        label="接收充电桩上送数据标志：0未接收、1已接收、2待上报账单">
      </el-table-column>
      <el-table-column
        prop="userId"
        header-align="center"
        align="center"
        label="用户ID">
      </el-table-column>
      <el-table-column
        prop="userName"
        header-align="center"
        align="center"
        label="用户名">
      </el-table-column>
      <el-table-column
        prop="userShortId"
        header-align="center"
        align="center"
        label="用户16位标示号">
      </el-table-column>
      <el-table-column
        prop="protocolType"
        header-align="center"
        align="center"
        label="设备协议类型:0新协议、1旧协议">
      </el-table-column>
      <el-table-column
        prop="vin"
        header-align="center"
        align="center"
        label="Vin，17位字符串">
      </el-table-column>
      <el-table-column
        prop="userType"
        header-align="center"
        align="center"
        label="用户账户类型： 0APP、1卡、2VIN、3、企业用户、4微信公众号、5微信小程序、6互联互通">
      </el-table-column>
      <el-table-column
        prop="payUuid"
        header-align="center"
        align="center"
        label="运营商绑定的支付通道ID">
      </el-table-column>
      <el-table-column
        prop="agentId"
        header-align="center"
        align="center"
        label="运营商ID">
      </el-table-column>
      <el-table-column
        prop="agentName"
        header-align="center"
        align="center"
        label="运营商名称">
      </el-table-column>
      <el-table-column
        prop="companyFlag"
        header-align="center"
        align="center"
        label="是否企业员工订单： 0普通用户、1企业用户可使用企业资金池、2平台订单(互联互通订单)">
      </el-table-column>
      <el-table-column
        prop="companyId"
        header-align="center"
        align="center"
        label="企业ID">
      </el-table-column>
      <el-table-column
        prop="companyName"
        header-align="center"
        align="center"
        label="企业名称">
      </el-table-column>
      <el-table-column
        prop="orderType"
        header-align="center"
        align="center"
        label="订单类型：1刷卡在线充电、2移动app充电、3vin充电、4刷卡离线充电、5微信公众号充电、6微信小程序充电、7互联互通充电">
      </el-table-column>
      <el-table-column
        prop="orderFlag"
        header-align="center"
        align="center"
        label="订单标志： 0平台订单、1第三方平台订单">
      </el-table-column>
      <el-table-column
        prop="stopCode"
        header-align="center"
        align="center"
        label="停机控制码 - 针对充电订单进行停车充电时">
      </el-table-column>
      <el-table-column
        prop="payStatus"
        header-align="center"
        align="center"
        label="支付状态： :0未支付、1已支付">
      </el-table-column>
      <el-table-column
        prop="startTime"
        header-align="center"
        align="center"
        label="开始时间">
      </el-table-column>
      <el-table-column
        prop="endTime"
        header-align="center"
        align="center"
        label="结束时间">
      </el-table-column>
      <el-table-column
        prop="chargingType"
        header-align="center"
        align="center"
        label="充电方式:01：电量控制充电；02：时间控制充电；03：金额控制充电；04：自动充满05：定时启动充电">
      </el-table-column>
      <el-table-column
        prop="chargingNumber"
        header-align="center"
        align="center"
        label="用户选择充电量 度、千瓦时/充电金额/单位：分钟,配合charging_type使用">
      </el-table-column>
      <el-table-column
        prop="chargingMark"
        header-align="center"
        align="center"
        label="充电标示号，充电桩启动充电成功后返回的">
      </el-table-column>
      <el-table-column
        prop="startSoc"
        header-align="center"
        align="center"
        label="起始SOC 百分比">
      </el-table-column>
      <el-table-column
        prop="endSoc"
        header-align="center"
        align="center"
        label="结束SOC 百分比">
      </el-table-column>
      <el-table-column
        prop="totalElec"
        header-align="center"
        align="center"
        label="充电总电量">
      </el-table-column>
      <el-table-column
        prop="totalTime"
        header-align="center"
        align="center"
        label="充电桩上传的充电时长：秒">
      </el-table-column>
      <el-table-column
        prop="startMeter"
        header-align="center"
        align="center"
        label="起始电表值">
      </el-table-column>
      <el-table-column
        prop="endMeter"
        header-align="center"
        align="center"
        label="结束电表值">
      </el-table-column>
      <el-table-column
        prop="startAmount"
        header-align="center"
        align="center"
        label="起始余额 单位：元">
      </el-table-column>
      <el-table-column
        prop="endAmount"
        header-align="center"
        align="center"
        label="结束余额 单位：元">
      </el-table-column>
      <el-table-column
        prop="chargingFee"
        header-align="center"
        align="center"
        label="充电费 单位：元">
      </el-table-column>
      <el-table-column
        prop="serviceFee"
        header-align="center"
        align="center"
        label="服务费 单位：元">
      </el-table-column>
      <el-table-column
        prop="totalAmount"
        header-align="center"
        align="center"
        label="总费用 单位：元">
      </el-table-column>
      <el-table-column
        prop="actualAmount"
        header-align="center"
        align="center"
        label="实收费用： 单位：元">
      </el-table-column>
      <el-table-column
        prop="serviceId"
        header-align="center"
        align="center"
        label="服务费ID">
      </el-table-column>
      <el-table-column
        prop="invoiceFlag"
        header-align="center"
        align="center"
        label="是否开发票： 0未开发票、1开具发票">
      </el-table-column>
      <el-table-column
        prop="pileId"
        header-align="center"
        align="center"
        label="充电桩ID">
      </el-table-column>
      <el-table-column
        prop="pileSn"
        header-align="center"
        align="center"
        label="充电桩出厂编号">
      </el-table-column>
      <el-table-column
        prop="pileName"
        header-align="center"
        align="center"
        label="充电桩名称">
      </el-table-column>
      <el-table-column
        prop="communicationSn"
        header-align="center"
        align="center"
        label="通讯编号，默认14位">
      </el-table-column>
      <el-table-column
        prop="driveNo"
        header-align="center"
        align="center"
        label="充电桩设备编号">
      </el-table-column>
      <el-table-column
        prop="gunId"
        header-align="center"
        align="center"
        label="充电枪ID">
      </el-table-column>
      <el-table-column
        prop="gunNo"
        header-align="center"
        align="center"
        label="充电枪编号">
      </el-table-column>
      <el-table-column
        prop="tcuSn"
        header-align="center"
        align="center"
        label="TCU编号">
      </el-table-column>
      <el-table-column
        prop="gunType"
        header-align="center"
        align="center"
        label="充电枪类型 0交流、1直流、2交直流一体">
      </el-table-column>
      <el-table-column
        prop="stationId"
        header-align="center"
        align="center"
        label="充电桩归属电站ID">
      </el-table-column>
      <el-table-column
        prop="stationName"
        header-align="center"
        align="center"
        label="充电站名称">
      </el-table-column>
      <el-table-column
        prop="parkingFeeFlag"
        header-align="center"
        align="center"
        label="是否收取停车费: 0免费、1收费">
      </el-table-column>
      <el-table-column
        prop="cardId"
        header-align="center"
        align="center"
        label="卡ID">
      </el-table-column>
      <el-table-column
        prop="createTime"
        header-align="center"
        align="center"
        label="创建时间 创建时间">
      </el-table-column>
      <el-table-column
        prop="createBy"
        header-align="center"
        align="center"
        label="创建人 创建人">
      </el-table-column>
      <el-table-column
        prop="updateTime"
        header-align="center"
        align="center"
        label="最后更新时间 最后更新时间">
      </el-table-column>
      <el-table-column
        prop="updateBy"
        header-align="center"
        align="center"
        label="最后更新人 最后更新人">
      </el-table-column>
      <el-table-column
        prop="cardSn"
        header-align="center"
        align="center"
        label="卡号">
      </el-table-column>
      <el-table-column
        prop="cardType"
        header-align="center"
        align="center"
        label="卡类型：0用户卡、1员工卡、2管理卡">
      </el-table-column>
      <el-table-column
        prop="branchId"
        header-align="center"
        align="center"
        label="网点ID">
      </el-table-column>
      <el-table-column
        prop="branchName"
        header-align="center"
        align="center"
        label="网点名称">
      </el-table-column>
      <el-table-column
        prop="cardBalance"
        header-align="center"
        align="center"
        label="充电前卡余额(平台记录的卡余额)">
      </el-table-column>
      <el-table-column
        prop="mergeFlag"
        header-align="center"
        align="center"
        label="是否并行充电：0常规充电、1并机充电">
      </el-table-column>
      <el-table-column
        prop="mergeOrderFlag"
        header-align="center"
        align="center"
        label="并机汇总订单标记：0汇总订单(需要扣款)、1分机订单">
      </el-table-column>
      <el-table-column
        prop="masterGunFlag"
        header-align="center"
        align="center"
        label="并机主枪标记：0主枪订单、1从枪订单">
      </el-table-column>
      <el-table-column
        prop="discountId"
        header-align="center"
        align="center"
        label="折扣规则ID">
      </el-table-column>
      <el-table-column
        prop="discountName"
        header-align="center"
        align="center"
        label="折扣规则名称">
      </el-table-column>
      <el-table-column
        prop="elecDiscount"
        header-align="center"
        align="center"
        label="充电费折扣比例">
      </el-table-column>
      <el-table-column
        prop="serviceDiscount"
        header-align="center"
        align="center"
        label="服务费折扣比例">
      </el-table-column>
      <el-table-column
        prop="totalDiscount"
        header-align="center"
        align="center"
        label="总金额折扣比例">
      </el-table-column>
      <el-table-column
        prop="oldDiscountServiceAmount"
        header-align="center"
        align="center"
        label="原始服务费折扣金额保留四位小数(单位：元)">
      </el-table-column>
      <el-table-column
        prop="discountServiceAmount"
        header-align="center"
        align="center"
        label="服务费折扣金额(单位：元)">
      </el-table-column>
      <el-table-column
        prop="oldDiscountChargerAmount"
        header-align="center"
        align="center"
        label="原始充电费折扣金额保留四位小数(单位：元)">
      </el-table-column>
      <el-table-column
        prop="discountChargerAmount"
        header-align="center"
        align="center"
        label="充电费折扣金额(单位：元)">
      </el-table-column>
      <el-table-column
        prop="oldDiscountOrderAmount"
        header-align="center"
        align="center"
        label="原始充电订单总金额折扣,保留四位小数(单位：元)">
      </el-table-column>
      <el-table-column
        prop="discountOrderAmount"
        header-align="center"
        align="center"
        label="充电订单总金额折扣(单位：元)">
      </el-table-column>
      <el-table-column
        prop="deductionMasterId"
        header-align="center"
        align="center"
        label="抵扣规则主表ID">
      </el-table-column>
      <el-table-column
        prop="deductionName"
        header-align="center"
        align="center"
        label="抵扣规则名称">
      </el-table-column>
      <el-table-column
        prop="deductionId"
        header-align="center"
        align="center"
        label="抵扣规则明细ID">
      </el-table-column>
      <el-table-column
        prop="deductionStartAmount"
        header-align="center"
        align="center"
        label="起始抵扣金额">
      </el-table-column>
      <el-table-column
        prop="deductionAmount"
        header-align="center"
        align="center"
        label="抵扣金额(单位：元)">
      </el-table-column>
      <el-table-column
        prop="deductionOrderAmount"
        header-align="center"
        align="center"
        label="抵扣订单金额(单位：元)">
      </el-table-column>
      <el-table-column
        prop="deductionStartTime"
        header-align="center"
        align="center"
        label="抵扣开始时间">
      </el-table-column>
      <el-table-column
        prop="deductionEndTime"
        header-align="center"
        align="center"
        label="抵扣结束时间">
      </el-table-column>
      <el-table-column
        prop="discountFlag"
        header-align="center"
        align="center"
        label="优惠类型：0无优惠、1明细折扣、2总价折扣、3满减、4混合优惠(折扣与满减一起使用)、5优惠卷">
      </el-table-column>
      <el-table-column
        prop="cardName"
        header-align="center"
        align="center"
        label="卡用户手机号">
      </el-table-column>
      <el-table-column
        prop="operatorId"
        header-align="center"
        align="center"
        label="第三方运营商ID">
      </el-table-column>
      <el-table-column
        prop="operatorName"
        header-align="center"
        align="center"
        label="第三方运营商名称">
      </el-table-column>
      <el-table-column
        prop="settlementTime"
        header-align="center"
        align="center"
        label="结算时间">
      </el-table-column>
      <el-table-column
        prop="pileCardBalance"
        header-align="center"
        align="center"
        label="桩上报的卡余额">
      </el-table-column>
      <el-table-column
        prop="vendorId"
        header-align="center"
        align="center"
        label="设备厂商ID">
      </el-table-column>
      <el-table-column
        prop="vendorName"
        header-align="center"
        align="center"
        label="设备厂商名称">
      </el-table-column>
      <el-table-column
        prop="stopReason"
        header-align="center"
        align="center"
        label="故障类型说明">
      </el-table-column>
      <el-table-column
        prop="stopStatus"
        header-align="center"
        align="center"
        label="结束状态：0正常结束、1故障结束">
      </el-table-column>
      <el-table-column
        prop="stopDetails"
        header-align="center"
        align="center"
        label="结束详情">
      </el-table-column>
      <el-table-column
        prop="stopStatusDesc"
        header-align="center"
        align="center"
        label="停止状态说明">
      </el-table-column>
      <el-table-column
        prop="connectorId"
        header-align="center"
        align="center"
        label="互联互通运营商设备ID">
      </el-table-column>
      <el-table-column
        prop="userCouponId"
        header-align="center"
        align="center"
        label="用户优惠卷ID">
      </el-table-column>
      <el-table-column
        prop="userCouponName"
        header-align="center"
        align="center"
        label="抵扣券别名">
      </el-table-column>
      <el-table-column
        prop="userCouponAmount"
        header-align="center"
        align="center"
        label="抵扣金额">
      </el-table-column>
      <el-table-column
        prop="userCouponInitialAmount"
        header-align="center"
        align="center"
        label="起始抵扣金额">
      </el-table-column>
      <el-table-column
        prop="actualCouponAmount"
        header-align="center"
        align="center"
        label="实际抵扣金额">
      </el-table-column>
      <el-table-column
        prop="oldServiceFee"
        header-align="center"
        align="center"
        label="桩上报的原始服务费">
      </el-table-column>
      <el-table-column
        prop="odometer"
        header-align="center"
        align="center"
        label="里程数">
      </el-table-column>
      <el-table-column
        prop="cartNo"
        header-align="center"
        align="center"
        label="车牌号码">
      </el-table-column>
      <el-table-column
        prop="parkFlag"
        header-align="center"
        align="center"
        label="停车系统推送标记：0未推送，1已推送">
      </el-table-column>
      <el-table-column
        prop="delFlag"
        header-align="center"
        align="center"
        label="是否删除: :0正常、1删除">
      </el-table-column>
      <el-table-column
        prop="remark"
        header-align="center"
        align="center"
        label="备注">
      </el-table-column>
      <el-table-column
        fixed="right"
        header-align="center"
        align="center"
        width="150"
        label="操作">
        <template slot-scope="scope">
          <el-button type="text" size="small" @click="addOrUpdateHandle(scope.row.id)">修改</el-button>
          <el-button type="text" size="small" @click="deleteHandle(scope.row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      @size-change="sizeChangeHandle"
      @current-change="currentChangeHandle"
      :current-page="pageIndex"
      :page-sizes="[10, 20, 50, 100]"
      :page-size="pageSize"
      :total="totalPage"
      layout="total, sizes, prev, pager, next, jumper">
    </el-pagination>
    <!-- 弹窗, 新增 / 修改 -->
    <add-or-update v-if="addOrUpdateVisible" ref="addOrUpdate" @refreshDataList="getDataList"></add-or-update>
  </div>
</template>

<script>
  import AddOrUpdate from './tordercharging-add-or-update'
  export default {
    data () {
      return {
        dataForm: {
          key: ''
        },
        dataList: [],
        pageIndex: 1,
        pageSize: 10,
        totalPage: 0,
        dataListLoading: false,
        dataListSelections: [],
        addOrUpdateVisible: false
      }
    },
    components: {
      AddOrUpdate
    },
    activated () {
      this.getDataList()
    },
    methods: {
      // 获取数据列表
      getDataList () {
        this.dataListLoading = true
        this.$http({
          url: this.$http.adornUrl('/generator/tordercharging/list'),
          method: 'get',
          params: this.$http.adornParams({
            'page': this.pageIndex,
            'limit': this.pageSize,
            'key': this.dataForm.key
          })
        }).then(({data}) => {
          if (data && data.code === 0) {
            this.dataList = data.page.list
            this.totalPage = data.page.totalCount
          } else {
            this.dataList = []
            this.totalPage = 0
          }
          this.dataListLoading = false
        })
      },
      // 每页数
      sizeChangeHandle (val) {
        this.pageSize = val
        this.pageIndex = 1
        this.getDataList()
      },
      // 当前页
      currentChangeHandle (val) {
        this.pageIndex = val
        this.getDataList()
      },
      // 多选
      selectionChangeHandle (val) {
        this.dataListSelections = val
      },
      // 新增 / 修改
      addOrUpdateHandle (id) {
        this.addOrUpdateVisible = true
        this.$nextTick(() => {
          this.$refs.addOrUpdate.init(id)
        })
      },
      // 删除
      deleteHandle (id) {
        var ids = id ? [id] : this.dataListSelections.map(item => {
          return item.id
        })
        this.$confirm(`确定对[id=${ids.join(',')}]进行[${id ? '删除' : '批量删除'}]操作?`, '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$http({
            url: this.$http.adornUrl('/generator/tordercharging/delete'),
            method: 'post',
            data: this.$http.adornData(ids, false)
          }).then(({data}) => {
            if (data && data.code === 0) {
              this.$message({
                message: '操作成功',
                type: 'success',
                duration: 1500,
                onClose: () => {
                  this.getDataList()
                }
              })
            } else {
              this.$message.error(data.msg)
            }
          })
        })
      }
    }
  }
</script>
