package com.guain.realtime.bean

case class PageActionLog(
                          mid :String,
                          user_id:String,
                          province_id:String,
                          channel:String,
                          is_new:String,
                          model:String,
                          operate_system:String,
                          version_code:String,
                          brand:String ,
                          page_id:String ,
                          last_page_id:String,
                          page_item:String,
                          page_item_type:String,
                          during_time:Long,
                          sourceType:String ,
                          action_id:String,
                          action_item:String,
                          action_item_type:String,
                          action_ts :Long ,
                          ts:Long
                        ) {

}
