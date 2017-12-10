# progressbarlibrary
-安卓loading加载框。

![](http://a1.qpic.cn/psb?/V13m9niH1maXkM/IcdbB40pW29PrBBhjJBF.mZ0xJOhFBeMIN2GxYq9H.4!/b/dPMAAAAAAAAA&bo=XAFJAgAAAAACwPI!&rf=viewer_4) 

How to

# gradle:
 ## Step 1 Add it in your root build.gradle at the end of repositories:
  ```
 allprojects {
		repositories {
			
			maven { url 'https://jitpack.io' }
		}
	}
 ```
 
  
 ## Step 2. Add the dependency
```  
  dependencies {
	        compile 'com.github.wangzaizhou:progressbarlibrary:v1.0'
	}
	
```

# 在你的代码中添加
```
	PgDialog pd=PgDialog.newInstance(context);
	if(!pd.isShowing()){
		pd.show("正在下载中...");
	  	pd.setData(10);//百分比
	}
	 
	   pd.dismiss();
```
