// V1 - BLUE - Pazhaya Version - Compare panna vachirukken
@GetMapping("/api/health")
public Map<String,String> health(){
  return Map.of("version","V1","message","Version 1 - Hello Everyone, you are watching Simply Byte jenkins da mapala series. Im Healthy","color","BLUE");
}
