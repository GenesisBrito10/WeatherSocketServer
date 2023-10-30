# Trabalho Redes Camada de Aplicação

**Alunos:**
- Fabricia Silva Machado
- Gênesis Jácome Ribeiro Brito

## Weather Socket Server

O Servidor Weather foi criado com a intenção de solicitar um serviço de previsão do tempo de qualquer cidade brasileira. Este documento irá especificar os símbolos e protocolos utilizados no sistema.

### 1. Símbolos

Os símbolos usados para especificar o início e o fim de cada protocolo são:

- Início: `#`protocolo`#`
- Fim: `#/`protocolo`#`

### 2. Protocolos

Nesta seção, serão apresentados os protocolos utilizados no servidor e como os clientes devem usá-los.

#### 2.1 - Temperatura
- Protocolo: `#temp#Cidade#/temp#`
- Descrição: Obtém a temperatura da cidade especificada.

#### 2.2 - Horas
- Protocolo: `#horas#Cidade#/horas#`
- Descrição: Obtém a hora atual da cidade especificada.

#### 2.3 - Temperatura Máxima de Hoje
- Protocolo: `#max_dia#Cidade#/max_dia#`
- Descrição: Solicita a temperatura máxima para o dia atual na cidade especificada.

#### 2.4 - Temperatura Mínima de Hoje
- Protocolo: `#min_dia#Cidade#/min_dia#`
- Descrição: Solicita a temperatura mínima para o dia atual na cidade especificada.

#### 2.5 - Dia/Noite da Cidade
- Protocolo: `#periodo#Cidade#/periodo#`
- Descrição: Obtém informações sobre o período do dia ou da noite na cidade especificada.

#### 2.6 - Umidade
- Protocolo: `#umid#Cidade#/umid#`
- Descrição: Obtém informações sobre a umidade na cidade especificada.

#### 2.7 - Nebulosidade
- Protocolo: `#neb#Cidade#/neb#`
- Descrição: Obtém informações sobre a nebulosidade na cidade especificada.

#### 2.8 - Volume de Chuva
- Protocolo: `#chuva#Cidade#/chuva#`
- Descrição: Obtém informações sobre o volume de chuva na cidade especificada.

#### 2.9 - Velocidade do Vento
- Protocolo: `#vel_vent#Cidade#/vel_vent#`
- Descrição: Obtém a velocidade do vento na cidade especificada.

#### 2.10 - Horário do Nascer do Sol
- Protocolo: `#nasc_sol#Cidade#/nasc_sol#`
- Descrição: Obtém o horário do nascer do sol na cidade especificada.

#### 2.11 - Fase da Lua
- Protocolo: `#lua#Cidade#/lua#`
- Descrição: Obtém a fase atual da Lua na cidade especificada.

#### 2.12 - Fuso Horário
- Protocolo: `#fuso_hora#Cidade#/fuso_hora#`
- Descrição: Obtém o fuso horário da cidade especificada.

#### 2.13 - Direção do Vento
- Protocolo: `#dir_vento#Cidade#/dir_vento#`
- Descrição: Obtém a direção do vento na cidade especificada.

#### 2.14 - Horário do Pôr do Sol
- Protocolo: `#por_sol#Cidade#/por_sol#`
- Descrição: Obtém o horário do pôr do sol na cidade especificada.

#### 2.15 - Previsão de Ontem
- Protocolo: `#prev_ant#Cidade#/prev_ant#`
- Descrição: Obtém a previsão do tempo do dia anterior na cidade especificada.

#### 2.16 - Condição do Clima de Hoje
- Protocolo: `#clima#Cidade#/clima#`
- Descrição: Obtém a condição atual do clima na cidade especificada.

#### 2.17 - Temperatura Mínima de Amanhã
- Protocolo: `#min_amanha#Cidade#/min_amanha#`
- Descrição: Solicita a temperatura mínima prevista para o próximo dia na cidade.

#### 2.18 - Temperatura Máxima de Amanhã
- Protocolo: `#max_amanha#Cidade#/max_amanha#`
- Descrição: Solicita a temperatura máxima prevista para o próximo dia na cidade.

#### 2.19 - Condição do Clima de Amanhã
- Protocolo: `#clima_amanha#Cidade#/clima_amanha#`
- Descrição: Obtém a condição do clima prevista para o próximo dia na cidade.

#### 2.20 - Sair do Servidor
- Protocolo: `#sair#Sair#/sair#`
- Descrição: Encerra a sessão ou sai do servidor. O texto "Digitar qualquer coisa" é um marcador que pode ser substituído por qualquer texto para encerrar a sessão.

**Nota:** Ao inserir a cidade desejada, evite usar acentos e, se a cidade tiver nome composto, escreva os espaços entre as palavras. Exemplo: `#clima_amanha#Rio de Janeiro#/clima_amanha#` é a forma correta.

