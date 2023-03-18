//package dataTypeTrans;
//
//import java.util.Map;
//
//import io.cucumber.java.DataTableType;
//import pojo.LumaAccountInfor;
//
//public class LumaNewAccountDataTransform {
//
//	@DataTableType
//		public LumaAccountInfor inforcovert(Map<String, String> data) {
//			LumaAccountInfor infor = new LumaAccountInfor(data.get("firstname") == null ? "" : data.get("firstname"),
//					data.get("lastname") == null ? "" : data.get("lastname"),
//					Boolean.valueOf(data.get("subscribed") == null ? "false" : data.get("subscribed")),
//					Boolean.valueOf(data.get("assistance") == null ? "false" : data.get("assistance")),
//					data.get("email") == null ? "" : data.get("email"), 
//					data.get("password") == null ? "" : data.get("password"),
//					data.get("passwordconfimation") == null ? "" : data.get("passwordconfimation"),
//			        Boolean.valueOf(data.get("showPassword") == null ? "false" : data.get("showPassword")));
//			return infor;
//		}
//
//}
