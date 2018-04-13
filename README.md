# baseStructure
BaseStructure is an android folder structure for developing android application using Model View Presenter (MVP).

## What is MVP?  
Model View Presenter (MVP) is the latest and greatest Android architecture pattern that helps you decouple business logic (Model) from view logic (Activity / Fragment) by utilizing an intermediate step called the Presenter.This architecture allows us to break our app into 3 layers - Models, Views and Presenters.

![MVP Architechture Image](https://github.com/koushikcse/baseStructure/blob/master/data/img/MVP.png)

### View:
This layer includes the Activities, Fragments or Android Views that the user view in an app. The general idea of this layer is very simple and there isn’t much to do here except to show the data to the user. There is not any business logic or major coding done in this layer.
### Presenter:
This layer is where the business logic is put and the major coding is done. The idea is to have one Presenter per View. But the Presenter can interact with multiple Models to interact with data which are obtained from databases and API calls.
### Model:
These are classes which interact with the data which are obtained from databases and API calls. They contain getter and setter methods to interact with data.

## Folder Structure
Folder structure is very importent to develop android application. When there are multiple developers working on a single project then must required a good architecture and standard folder structure, so that every developer can easily understand where need to write which code. This application has the following packages.
```
 Package Structure
 
     ./baseStructure
      ./application
      ./dataStorage
      ./dependencyInjection
      ./pushNotification
      ./modules
            ./splash
            ./auth
                 ./login
                 ./signup
                 ./forgotPassword
                 ./changePassword
                 ./model
            ./common
                ./model
                ./adapters
                ...
            ./home
            ...
      ./network
      ./shared
      ./socialLogin
      ./utils
      
```
Inside **application** folder there is application class and here we'll write appication label functionality. Inside **dataStorage** there are subfolders as *sharedPreference*,*realm* and *filestores*. Here we will write local database related classes and functionality as well. Dependency Injection related classes and functionality are inside **dependencyInjection** folder. Inside **network** folder keep all the network related classes and session or token handling functionality. In **shared** folder keep that classes which will be used from any module and inside **utils** folder keep utility classes. If there are any other features like push notification, social login then create different folders for that feature. Now see the **modules** folder, here we'll create separate folders for each different screens. But see in the folder structure, inside **auth** folder there are *login*,*signup*,*changepassword*,*forgotpassword* and *model* folders. As these features are very common, related to user-authentication and models of these features will be less. So we can keep all models for these modules in a common folder as *model* and API related classes (restservice and restinterface) and fuctionality are also written inside auth folder commonly. And there is one folder **common** where we will keep common models and adapters which will be used from different screens.

## Modules Communication
How modules communicate and navigate one screen to another screen shows in the following image.

![Modules Communication Image](https://github.com/koushikcse/baseStructure/blob/master/data/img/modulesCommunication.png)



## License

MIT License
```
Copyright (c) 2018 Koushik Mondal

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
