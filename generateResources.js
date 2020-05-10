const fs = require('fs');
const path = require('path');

let langEntries = '';

let ROCK_TYPES = [
  'blaimorite',
  'boninite',
  'carbonatite',
  'foidolite',
  'arkose',
  'jaspillite',
  'travertine',
  'wackestone',
  'blueschist',
  'greenschist',
  'cataclasite',
  'mylonite'
]

let ORE_TYPES = {
  'native_copper': true,
  'native_gold': true,
  'native_platinum': true,
  'hematite': true,
  'native_silver': true,
  'cassiterite': true,
  'galena': true,
  'bismuthinite': true,
  'garnierite': true,
  'malachite': true,
  'magnetite': true,
  'limonite': true,
  'sphalerite': true,
  'tetrahedrite': true,
  'bituminous_coal': false,
  'lignite': false,
  'kaolinite': false,
  'gypsum': false,
  'satinspar': false,
  'selenite': false,
  'graphite': false,
  'kimberlite': false,
  'petrified_wood': false,
  'sulfur': false,
  'jet': false,
  'microcline': false,
  'pitchblende': false,
  'cinnabar': false,
  'cryolite': false,
  'saltpeter': false,
  'serpentine': false,
  'sylvite': false,
  'borax': false,
  'olivine': false,
  'lapis_lazuli': false,
  'native_ardite': true,
  'rutile': true,
  'native_osmium': true,
  'bauxite': true,
  'wolframite': true,
  'cobaltite': true,
  'thorianite': false,
  'chromite': false,
  'pyrolusite': false,
  'magnesite': false,
  'boron': false,
  'spodumene': false,
  'stibnite': false,
  'mawsonite': false
}
let FULLBLOCK_TYPES = [
  'raw',
  'smooth',
  'cobble',
  'bricks',
  'sand',
  'gravel',
  'dirt',
  'clay',
]
let GRASS_TYPES = [
  'grass',
  'dry_grass',
  'clay_grass',
  'path',
  'FarmLand'
]

let DECORATION_TYPES = [
  'stairs',
  'slab',
  'double_slab',
  'wall'
]

function capitalizeFirstLetter(str) {
  return str.charAt(0).toUpperCase() + str.slice(1);
}


for (let rockType of ROCK_TYPES) {
  langEntries = langEntries.concat(`# ${rockType}\n`)

  // spikes
  langEntries = langEntries.concat(`tile.tfc.spike.${rockType}.name=${capitalizeFirstLetter(rockType)} Spike \n`)

  // buttons
  langEntries = langEntries.concat(`tile.tfc.stone.button.${rockType}.name=${capitalizeFirstLetter(rockType)} Spike \n`)

  // rock item
  langEntries = langEntries.concat(`item.tfc.rock.${rockType}.name=${capitalizeFirstLetter(rockType)} Rock\n`)
  langEntries = langEntries.concat(`item.tfc.brick.${rockType}.name=${capitalizeFirstLetter(rockType)} Brick\n`)

  for (let blockType of FULLBLOCK_TYPES) {
    if(['cobble', 'bricks', 'sand', 'gravel', 'dirt', 'clay'].includes(blockType)) {
      langEntries = langEntries.concat(`tile.tfc.${blockType}.${rockType}.name=${capitalizeFirstLetter(rockType)} ${capitalizeFirstLetter(blockType)}\n`)
    }
    else {
      langEntries = langEntries.concat(`tile.tfc.${blockType}.${rockType}.name=${capitalizeFirstLetter(blockType)} ${capitalizeFirstLetter(rockType)}\n`)
    }
  }
  for (let grassType of GRASS_TYPES) {
    if(!['FarmLand', 'grass', 'path'].includes(grassType))
    langEntries = langEntries.concat(`tile.tfc.${grassType.toLowerCase()}.${rockType}.name=${capitalizeFirstLetter(rockType)} ${capitalizeFirstLetter(grassType.split('_')[0])} ${capitalizeFirstLetter(grassType.split('_')[1])}\n`)
    else {
      langEntries = langEntries.concat(`tile.tfc.${grassType.toLowerCase()}.${rockType}.name=${capitalizeFirstLetter(rockType)} ${capitalizeFirstLetter(grassType)}\n`);
    }
  }

  for (let decorationType of DECORATION_TYPES) {
    for (type of ['smooth', 'cobble', 'bricks']) {
      if(decorationType == 'double_slab') {
        langEntries = langEntries.concat(`tile.tfc.${decorationType.toLowerCase()}.${type}.${rockType}.name=${capitalizeFirstLetter(type)} ${capitalizeFirstLetter(rockType)} ${capitalizeFirstLetter(decorationType.split('_')[0])} ${capitalizeFirstLetter(decorationType.split('_')[1])}\n`)
      }
      else {
        if(type == 'bricks' || type == 'cobble') {
          langEntries = langEntries.concat(`tile.tfc.${decorationType.toLowerCase()}.${type}.${rockType}.name=${capitalizeFirstLetter(rockType)} ${capitalizeFirstLetter(type)} ${capitalizeFirstLetter(decorationType)}\n`);
        }
        else {
          langEntries = langEntries.concat(`tile.tfc.${decorationType.toLowerCase()}.${type}.${rockType}.name=${capitalizeFirstLetter(type)} ${capitalizeFirstLetter(rockType)} ${capitalizeFirstLetter(decorationType)}\n`);
        }
      }
    }
  }
  for (let oreType of Object.keys(ORE_TYPES)) {
    if(oreType.includes('_')) {
      langEntries = langEntries.concat(`tile.tfc.ore.${oreType.toLowerCase()}.${rockType}.name=${capitalizeFirstLetter(rockType)} ${capitalizeFirstLetter(oreType.split('_')[0])} ${capitalizeFirstLetter(oreType.split('_')[1])}\n`);
    }
    else {
      langEntries = langEntries.concat(`tile.tfc.ore.${oreType.toLowerCase()}.${rockType}.name=${capitalizeFirstLetter(rockType)} ${capitalizeFirstLetter(oreType)}\n`);
    }
  }
}

console.log("Finished Generating Lang entries!");

fs.writeFileSync('./src/main/resources/assets/tfc/lang/en_us.lang', langEntries,'utf8');

let recipes = {
  bricks:{
    "type": "minecraft:crafting_shaped",
    "pattern": [
      "XOX",
      "OXO",
      "XOX"
    ],
    "key": {
      "O": {
        "type": "forge:ore_dict",
        "ore": "mortar"
      },
      "X": {
        "item": "tfc:brick/stoned"
      }
    },
    "result": {
      "item": "tfc:bricks/stoned",
      "count": 4
    }
  },
  brick:{
    "type": "tfc:damage_item_shapeless",
    "ingredients": [
      {
        "item": "tfc:rock/stoned"
      },
      {
        "type": "forge:ore_dict",
        "ore": "chisel"
      }
    ],
    "result": {
      "item": "tfc:brick/stoned",
      "count": 1
    }
  },
  smooth_stairs:{
    "type": "minecraft:crafting_shaped",
    "pattern": [
      "X  ",
      "XX ",
      "XXX"
    ],
    "key": {
      "X": {
        "item": "tfc:smooth/stoned"
      }
    },
    "result": {
      "item": "tfc:stairs/smooth/stoned",
      "count": 8
    }
  },
  smooth_walls:{
    "type": "minecraft:crafting_shaped",
    "pattern": [
      "XXX",
      "XXX"
    ],
    "key": {
      "X": {
        "item": "tfc:smooth/stoned"
      }
    },
    "result": {
      "item": "tfc:wall/smooth/stoned",
      "count": 8
    }
  },
  smooth_slab:{
    "type": "minecraft:crafting_shaped",
    "pattern": [
      "XXX"
    ],
    "key": {
      "X": {
        "item": "tfc:smooth/stoned"
      }
    },
    "result": {
      "item": "tfc:slab/smooth/stoned",
      "data": 0,
      "count": 6
    }
  },
  smooth:{
    "type": "tfc:damage_item_shapeless",
    "ingredients": [
      {
        "item": "tfc:raw/stoned"
      },
      {
        "type": "forge:ore_dict",
        "ore": "chisel"
      }
    ],
    "result": {
      "item": "tfc:smooth/stoned",
      "count": 1
    }
  },
  rock:{
    "type": "minecraft:crafting_shapeless",
    "ingredients": [
      {
        "item": "tfc:cobble/stoned"
      }
    ],
    "result": {
      "item": "tfc:rock/stoned",
      "count": 4
    }
  },
  cobble_wall:{
    "type": "minecraft:crafting_shaped",
    "pattern": [
      "XXX",
      "XXX"
    ],
    "key": {
      "X": {
        "item": "tfc:cobble/stoned"
      }
    },
    "result": {
      "item": "tfc:wall/cobble/stoned",
      "count": 8
    }
  },
  cobble_stairs:{
    "type": "minecraft:crafting_shaped",
    "pattern": [
      "X  ",
      "XX ",
      "XXX"
    ],
    "key": {
      "X": {
        "item": "tfc:cobble/stoned"
      }
    },
    "result": {
      "item": "tfc:stairs/cobble/stoned",
      "count": 8
    }
  },
  cobble_slab:{
    "type": "minecraft:crafting_shaped",
    "pattern": [
      "XXX"
    ],
    "key": {
      "X": {
        "item": "tfc:cobble/stoned"
      }
    },
    "result": {
      "item": "tfc:slab/cobble/stoned",
      "data": 0,
      "count": 6
    }
  },
  cobble:{
    "type": "minecraft:crafting_shaped",
    "pattern": [
      "XX",
      "XX"
    ],
    "key": {
      "X": {
        "item": "tfc:rock/stoned"
      }
    },
    "result": {
      "item": "tfc:cobble/stoned",
      "count": 1
    }
  },
  button:{
    "type": "tfc:damage_item_shapeless",
    "ingredients": [
      {
        "item": "tfc:brick/stoned"
      },
      {
        "type": "forge:ore_dict",
        "ore": "chisel"
      }
    ],
    "result": {
      "item": "tfc:stone/button/stoned",
      "count": 1
    }
  },
  bricks_wall:{
    "type": "minecraft:crafting_shaped",
    "pattern": [
      "XXX",
      "XXX"
    ],
    "key": {
      "X": {
        "item": "tfc:bricks/stoned"
      }
    },
    "result": {
      "item": "tfc:wall/bricks/stoned",
      "count": 8
    }
  },
  bricks_stairs:{
    "type": "minecraft:crafting_shaped",
    "pattern": [
      "X  ",
      "XX ",
      "XXX"
    ],
    "key": {
      "X": {
        "item": "tfc:bricks/stoned"
      }
    },
    "result": {
      "item": "tfc:stairs/bricks/stoned",
      "count": 8
    }
  },
  bricks_slab:{
    "type": "minecraft:crafting_shaped",
    "pattern": [
      "XXX"
    ],
    "key": {
      "X": {
        "item": "tfc:bricks/stoned"
      }
    },
    "result": {
      "item": "tfc:slab/bricks/stoned",
      "data": 0,
      "count": 6
    }
  },
}

function generateRecipes() {
  for(rock of ROCK_TYPES) {
    let folderpath = `./src/main/resources/assets/tfc_rocksplus/recipes/stone/${rock}`;
    fs.mkdirSync(folderpath)
    for (let i = 0; i < Object.values(recipes).length; i++) {
      let value = Object.values(recipes)[i];
      let key = Object.keys(recipes)[i];
      
      let str = JSON.stringify(value, null, 2);
      str = str.split("stoned").join(rock);

      fs.writeFileSync(`${folderpath}/${rock}_${key}.json`, str, 'utf8');
    }
  }
  console.log("Finished generating recipes!")
}

// used to generate recipes for the various stones
generateRecipes();