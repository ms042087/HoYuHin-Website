# Notes

## AutoCAD

1. BatchPlot: Need to save the file before running the command, otherwise the file list cannot be saved
2. In plot, use window button to select the area to be printed
3. **Hide grid line** in layout: F7/Fn+F7/Ctrl+G/Cmd+G
4. For Simplified Chinese, please use command SYSCODEPAGE to check the system code. It should be ANSI_936. If not, go to window tab -> Region & language settings -> Administrative language settings -> change system locale : Chinese (simplified, China)

## ELV system design rule of thumb

1. Projector system  

- 20 sqm/item
- 3 kW/item
- Ceiling installation assume 20 kg
- Example calculation: 20 projectors -> 20*3kW = 60kW. With 20% spare => 70 kW

2. LED panel

- Indoor P2.5 (P stand for pixel pitch)
- 0.9 kW/sqm
- 30kg/item

3. IT room

- 20* 1200x800 雙門機櫃 (一個機櫃 4kW)
- 1 workstation
- 120 mins UPS
- FM200 氣體滅火
- environment monitoring
- Earthing 端子 <1ohm
- 500 Lx 照明
- 18-24 temperature, 40-55% humidity

4. Optical fibre

- 2 modes: OS & OM (Optical single mode & Optical multiple mode)
- >1km use OS, >10Gb/s use OM

5. WiFi system

- RSSI > 65dbm

6. data network

- Load balancer
- DMZ (demilitarized zone)

7. BGM system

- ambient noise sensor collects background noise to adjust the volume of BGM

8. curved LED

- p2.5
- 800 cd/sqm
- IP31
- 7kg/sqm

9. outdoor LED screen

- p8
- 6000 cd/sqm
- IP 65 & IP54 for front and back
- 38kg/sqm

10. 機房接地系統

- SPD (Surge Protection Device)

設計概念:  
住宅系統，大物業系統  
電訊接入方法: 園區接入，地塊接入  
電訊商 -> 電訊設備房 ->總配線架->光纖配線架->分光器  
主幹橋架-> 垂直配線架->分光器->水平配線架  
網絡結構: 三層: 核心層，匯聚層，接入層
