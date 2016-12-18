## Java IO 相关知识   
java.io 包内的大部分与操作相关的成员都实现 **Closeable**  接口   
**Writer** 和 **OutputStream** 相关的成员都实现了 **Flushable** 接口   
中间夹杂了四个接口，分别是:**DataInput**、**ObjectInput**、**DataOutput**、**ObjectOutut** ,外加一个 **Console**  
定义相关的部分成员实现了 **Serialzable** 接口   
其中操作相关的成员有四大部分，分别是:

- **Reader**
![](java.io.1.png)
- **InputStream**
![](java.io.2.png)
- **Writer**
![](java.io.3.png)
- **OutputStream**
![](java.io.4.png)

定义相关的成员中，实现了 **Serialzable** 接口的有:  

* IOException 及其子类   
* FilePermission     
* FilePermissionCollection    
* IOError   
* File   
* ObjectStreamClass   
* SerializablePermission   
* Externalizable   
* UncheckedIOException   

没有实现 **Serialzable** 的有:   

* StreamTokenizer   
* FileSystem 及其子类   
* FileDescriptor   
* ObjectStreamField   
* ExpiringCache   
* SerialCallbackContext    
* DeleteOnExitHook    
* ObjectInputValidation    
* DefaultFileSystem     
* FilenameFilter    
* FileFilter    
* Bits    

