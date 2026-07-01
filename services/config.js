const config = {
  testMode: true,
  //cadu oi su botei true pra mexer no card depois so botar false pra testar o n8n
  //essa parte aqui em cima depois quando tudo estiver funcionando so botar false
  //e so uma funcao de teste que eu cria pra mexer nos e poder testar os cards
  
  api: {
    baseURL: "http://localhost:8080",
    chatEndpoint: "/api/chat",
    timeout: 10000,
  },

  chat: {
    typingDelay: 800,
    maxMessageLength: 500,
  },
};

export default config;