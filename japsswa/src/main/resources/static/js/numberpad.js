const Keyboard = {
  elements: {
      main: null,
      keysContainer: null,
      keys: []
  },

  eventHandlers: {
      oninput: null,
      onclose: null
  },

  properties: {
      value: "",
      capsLock: false
  },

  init() {
      // 숫자 패드 전체 및 키 컨테이너 :  div 태그 생성.
      this.elements.main = document.createElement("div");
      this.elements.keysContainer = document.createElement("div");

      // 숫자패드 전체 컨테이너 : 클래스 부여
      // 처음 상태: 숨김
      this.elements.main.classList.add("number_pad", "number_pad--hidden");
      // 
      this.elements.keysContainer.classList.add("number_pad__keys");
      this.elements.keysContainer.appendChild(this._createKeys());

      this.elements.keys = this.elements.keysContainer.querySelectorAll(".number_pad__key");

      // DOM 추가
      this.elements.main.appendChild(this.elements.keysContainer);
      document.body.appendChild(this.elements.main);

      // input 창에 포커스가 되면 숫자패드 띄우기
      document.querySelectorAll("#failItem").forEach(element => {
          element.addEventListener("click", () => {
              this.open(element.value, currentValue => {
                  element.value = currentValue;
              });
          });
      });
  },

  _createKeys() {
      const fragment = document.createDocumentFragment();
      const keyLayout = [
          "1", "2", "3", "backspace",
          "4", "5", "6", "0",
          "7", "8", "9", "X"    
      ];

      // HTML 아이콘 추가하기
      const createIconHTML = (icon_name) => {
          return `<i class="material-icons">${icon_name}</i>`;
      };

      keyLayout.forEach(key => {
          const keyElement = document.createElement("button");
          const insertLineBreak = ["backspace", "0", "X"].indexOf(key) !== -1;

          // 각 클래스 및 속성 추가.
          keyElement.setAttribute("type", "button");
          keyElement.classList.add("number_pad__key");

          switch (key) {
              case "backspace":
                  keyElement.classList.add("number_pad__key--wide");
                  keyElement.innerHTML = createIconHTML("backspace");

                  keyElement.addEventListener("click", () => {
                      this.properties.value = this.properties.value.substring(0, this.properties.value.length - 1);
                      this._triggerEvent("oninput");
                  });

                  break;

              case "X" :
                  keyElement.classList.add("number_pad__key--dark");
                  keyElement.innerHTML = createIconHTML("cancel");

                  keyElement.addEventListener("click", () => {
                      this.close();
                      this._triggerEvent("onclose");
                  });

                  break;

              default:
                  keyElement.textContent = key.toLowerCase();

                  keyElement.addEventListener("click", () => {
                      this.properties.value += this.properties.capsLock ? key.toUpperCase() : key.toLowerCase();
                      this._triggerEvent("oninput");
                  });

                  break;
          }

          fragment.appendChild(keyElement);

          if (insertLineBreak) {
              fragment.appendChild(document.createElement("br"));
          }
      });

      return fragment;
  },

  _triggerEvent(handlerName) {
      if (typeof this.eventHandlers[handlerName] == "function") {
          this.eventHandlers[handlerName](this.properties.value);
      }
  },


  open(initialValue, oninput, onclose) {
      this.properties.value = initialValue || "";
      this.eventHandlers.oninput = oninput;
      this.eventHandlers.onclose = onclose;
      this.elements.main.classList.remove("number_pad--hidden");
  },

  close() {
      this.properties.value = "";
      this.eventHandlers.oninput = oninput;
      this.eventHandlers.onclose = onclose;
      this.elements.main.classList.add("number_pad--hidden");
  }
};

window.addEventListener("DOMContentLoaded", function () {
  Keyboard.init();
});