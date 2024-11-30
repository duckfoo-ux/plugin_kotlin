# 구성
```
example-plugin
└── src
    └── main
        ├── kotlin  
        └── resources
            ├── config.yml
            └── plugin.yml
```
! 주의사항 !
plugin.ymlㅣconfig.yml은  꼭 resources 파일안에 넣어두기

# 매인
override
    public void onEnable() {
    // ...
    }
서버 시작메시지
```
logger.info("시작")
```
## 커맨드ㅣ이밴트버 시작메시지
```
logger.info("시작")
```
## 커맨드ㅣ이벤트 등록
```
getCommand("jammand")!!.setExecutor(this)
server.pluginManager.registerEvents(this, this)
```




코틀린에선 @override 가 아닌  override 를 사용한다 



config.yml 있다면
```
        saveDefaultConfig(); // 이건 config.yml 있을때 쓰기
        saveResource("config.yml",  false); // 이건 config.yml 있을때 쓰기
```




# plugin.yml
```
name: 
version: 
main: 
description: A
author: 
website: 
api-version:
commands:
```

# config.yml
플러그인이 초기화되면 이 리소스를 플러그인의 데이터 디렉토리에 저장해야 사용자가 값을 편집할 수 있습니다. 플러그인에서 이를 수행하는 방법의 예는 다음과 같습니다 onEnable

```
public class TestPlugin extends JavaPlugin {

    override
    public void onEnable() {
        saveDefaultConfig()

        
         saveResource("config.yml", false)

        
    }

}
```


# command:

```
public class ExampleListener implements CommandExecutor {
    // ...
}
```
써주기!
```
    @Override
    public void onEnable() {
        getCommand("Kommand")!!.setExecutor(this)
    }

```
jammand 에 커맨드 이름 써주기 커맨드 이름은 plugin.yml에서
```
name: oncommandkotlin
version: '$version'
main: io.github.duckfooux.commandkotlin.plugin
api-version: '1.20'
author: duckfoo
libraries:
  - io.github.duckfoo:oncommandkotlin-core:<version>
commands:
    Kommand:
      description: Jammand
```
써주기

// Ctrl + o 를 사용하여 onCommand  추가 
```
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
      // . . .
        return true
    }
```




# Event
```
class kv : JavaPlugin(), Listener  {
    // ...
}
```
  
필요 
```
    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
      // . . .
    }

```
 꼭 @EventHandler 써주기!!
# 상자 ui (open inventory)
커맨드와 이밴트 핸들러를 같이써서  상자 ui를 열려면
```
public class Iv extends JavaPlugin implements Listener, CommandExecutor {

class Iv : JavaPlugin(), Listener, CommandExecutor {

    override fun onEnable() {
        server.pluginManager.registerEvents(this, this)
        getCommand("iv")?.setExecutor(this)
    }

    override fun onDisable() {

    }
```

ctrl+o 로 onCommand 추가 그리고 예시:

```
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) {
            sender.sendMessage("${ChatColor.RED}This command can only be used by players!")
            return true
        }

        val player: Player = sender
        val inventory: Inventory = Bukkit.createInventory(null, 27, "${ChatColor.BLACK}Iv")

        if (args.isEmpty()) {
            player.sendMessage("${ChatColor.RED}Usage: /iv <player>")
        } else if (args.size == 1 && args[0].equals("player", ignoreCase = true)) {
            player.openInventory(inventory)
        }

        return true
    }
}



```
여기서 상자가 1번칸이 아니라 0번칸부터 시작 
26칸의 상자를 열려면 27을 써주기 
plugin.yml에 추가 


gardle 설정 
```
tasks.build {
    dependsOn("shadowJar")
}

tasks.processResources {
    val props = mapOf("version" to version)
    inputs.properties(props)
    filteringCharset = "UTF-8"
    filesMatching("plugin.yml") {
        expand(props)
    }
}
```
settings.gardle.kts 
```
rootProject.name = ""

val prefix = rootProject.name

include("$prefix-api", "$prefix-core", "$prefix-plugin")

val dongle = "$prefix-dongle"
val dongleFile = file(dongle)
if (dongleFile.exists()) {
    include(dongle)
//     load nms
    dongleFile.listFiles()?.filter {
        it.isDirectory && it.name.startsWith("v")
    }?.forEach { file ->
        include(":$dongle:${file.name}")
    }
}

val publish = "$prefix-publish"
if (file(publish).exists()) include(publish)
```



 
