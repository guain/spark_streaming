package com.guain.realtime.util

import com.guain.realtime.bean.DauInfo
import com.guain.realtime.bean.{DauInfo, PageLog}

import java.lang.reflect.{Field, Method, Modifier}
import scala.util.control.Breaks

/**
  * 实现对象属性拷贝.
  */
object MyBeanUtils {

  def main(args: Array[String]): Unit = {
    val pageLog: PageLog =
      PageLog("mid1001" , "uid101" , "prov101" , null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,0L ,null ,123456)

    val dauInfo: DauInfo = new DauInfo()
    println("拷贝前: " + dauInfo)

    copyProperties(pageLog,dauInfo)

    println("拷贝后: " + dauInfo)

  }

  /**
    * 将srcObj中属性的值拷贝到destObj对应的属性上.
    */
  def copyProperties(srcObj : AnyRef , destObj: AnyRef): Unit ={
    if(srcObj == null || destObj == null ){
      return
    }
    //获取到srcObj中所有的属性
    val srcFields: Array[Field] = srcObj.getClass.getDeclaredFields

    //处理每个属性的拷贝
    for (srcField <- srcFields) {
      Breaks.breakable{
        //get / set
        // Scala会自动为类中的属性提供get、 set方法
        // get : fieldname()
        // set : fieldname_$eq(参数类型)

        //getMethodName
        var getMethodName : String = srcField.getName
        //setMethodName
        var setMethodName : String = srcField.getName+"_$eq"

        //从srcObj中获取get方法对象，
        val getMethod: Method = srcObj.getClass.getDeclaredMethod(getMethodName)
        //从destObj中获取set方法对象
        // String name;
        // getName()
        // setName(String name ){ this.name = name }
        val setMethod: Method =
        try{
          destObj.getClass.getDeclaredMethod(setMethodName, srcField.getType)
        }catch{
          // NoSuchMethodException
          case ex : Exception =>  Breaks.break()
        }

        //忽略val属性
        val destField: Field = destObj.getClass.getDeclaredField(srcField.getName)
        if(destField.getModifiers.equals(Modifier.FINAL)){
          Breaks.break()
        }
        //调用get方法获取到srcObj属性的值， 再调用set方法将获取到的属性值赋值给destObj的属性
        setMethod.invoke(destObj, getMethod.invoke(srcObj))
      }

    }

  }

}
