package com.rrw.donate.vo.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @description:
 * @author: RRW friend_rrw@163.com
 * @create: 2021-08-05 22:05
 */
@Getter
@Setter
public class ResponOrderListVo {
    private Long id;
    /**
     * 充电费 单位：元
     */
    private BigDecimal chargingFee;
    /**
     * 充电桩ID
     */
    private Long pileId;
    /**
     * 充电桩名称
     */
    private String pileName;

    private Long stationId;
    /**
     * 充电站名称
     */
    private String stationName;
}
