function check(){
    const deletePost = document.getElementById("hidden")
    if(confirm("are you sure?")!= true){
        deletePost.setAttribute("value","0")
    }
}