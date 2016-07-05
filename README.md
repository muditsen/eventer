#Eventer
Event Bus to create dynamic events throughout your project.

##Prerequisites

add this 
```
allprojects {
    repositories {
        jcenter()
        maven {
            url 'https://dl.bintray.com/iammuditsen/maven/'
        }
    }
}
```
Note: above do not allprojects tag in any parent tag.
<br/>
<br/>

to app gradle file and in dependencies add

```
compile 'muditse.android:eventer:1.0.0'
```

##Usage

###To create a event 
```
String CLICK_EVENT  = "button_clicked";

EventManager.getInstance().createEvent(CLICK_EVENT);

```

###To fire Event
```
EventManager.getInstance().fireEvent(CLICK_EVENT,null);
```
or 

```
 ArrayList<ModelFile> listOfModels= new List<ModelFile>();
 EventManager.getInstance().fireEvent(CLICK_EVENT,listOfModels);
```

You can pass any object when firing event.

###Reading Events
```
EventManager.getInstance().addObserver(MainActivity.CLICK_EVENT, new Observer() {
            @Override
            protected void update(Object obj) {
                //You can cast this object what you have passed above while firing event
                if(obj != null){
                  List listOfModels = (ArrayList<ModelFile>) obj;
                }
                textView.setText("Activity Click Event Fragment 1 :O :O");
            }
        });
```
<br/><br/>Note:Refer sample project for usage.

#License

Copyright (C) 2015 Mudit Sen muditsen1234@gmail.com

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
