# AlertDialog
自定义dialog，listview的字体变颜色
=====

自定义layout添加dialog
------

LayoutInflater加载布局            <br>
三种方式获得实例     <br>
 LayoutInflater layoutInflater = getLayoutInflater();//调用Activity的getLayoutInflater() <br>
 LayoutInflater layoutInflater = LayoutInflater.from(context);  <br>
 LayoutInflater layoutInflater =  (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);<br>
 一般用LayoutInflater layoutInflater = LayoutInflater.from(context);  <br>
 <br>
 LayoutInflater的实例之后就可以调用它的inflate()方法来加载布局了<br>
 layoutInflater.inflate(resourceId, root);  <br>
 inflate()方法一般接收两个参数，第一个参数就是要加载的布局id，第二个参数是指给该布局的外部再嵌套一层父布局，如果不需要就直接传null。这样就成功成功创建了一个布局的实例，之后再将它添加到指定的位置就可以显示出来了。<br>
 builder.setView把layout布局设置到dialog上<br>
 自定义dialog和builder相关联，才能让dialog dismiss<br>
 AlertDialog dialog=builder.show()<br>
 在点击事件中dialog.dismiss()<br>
 
 listview字体变颜色
 ------
 
ListView使用android.R.layout.simple_list_item_1时显示默认字体，用java代码改变获取到的View的字体颜色，此时ListView每一项都可以有点击效果<br>
相当于重写了view视图，改变了原本的字体颜色，返回view中<br>
ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,data){<br>
                    public View getView(int position, View convertView, ViewGroup parent){<br>
                        View view1=super.getView(position,convertView,parent);<br>
                        TextView textView=view1.findViewById(android.R.id.text1);<br>
                        textView.setTextColor(Color.WHITE);<br>
                        return view1;<br>
                    }<br>
                };<br>
