'use strict';

Object.defineProperty(exports, '__esModule', { value: true });

var vue = require('vue');

function hColgroup(props) {
  const isAuto = props.tableLayout === "auto";
  let columns = props.columns || [];
  if (isAuto) {
    if (columns.every((column) => column.width === void 0)) {
      columns = [];
    }
  }
  const getPropsData = (column) => {
    const propsData = {
      key: `${props.tableLayout}_${column.id}`,
      style: {},
      name: void 0
    };
    if (isAuto) {
      propsData.style = {
        width: `${column.width}px`
      };
    } else {
      propsData.name = column.id;
    }
    return propsData;
  };
  return vue.h("colgroup", {}, columns.map((column) => vue.h("col", getPropsData(column))));
}
hColgroup.props = ["columns", "tableLayout"];

exports.hColgroup = hColgroup;
//# sourceMappingURL=h-helper.js.map
