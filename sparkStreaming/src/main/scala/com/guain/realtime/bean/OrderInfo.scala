package com.guain.realtime.bean

case class OrderInfo(
                      id: Long =0L,
                      province_id: Long=0L,
                      order_status: String=null,
                      user_id: Long=0L,
                      total_amount:  Double=0D,
                      activity_reduce_amount: Double=0D,
                      coupon_reduce_amount: Double=0D,
                      original_total_amount: Double=0D,
                      feight_fee: Double=0D,
                      feight_fee_reduce: Double=0D,
                      expire_time: String =null,
                      refundable_time:String =null,
                      create_time: String=null,
                      operate_time: String=null,

                      var create_date: String=null, // 把其他字段处理得到
                      var create_hour: String=null,

                      var province_name:String=null,//查询维度表得到
                      var province_area_code:String=null,
                      var province_3166_2_code:String=null,
                      var province_iso_code:String=null,

                      var user_age :Int=0, //查询维度表得到
                      var user_gender:String=null

                    ) {

}
