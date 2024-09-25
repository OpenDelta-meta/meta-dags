require dags-dvb-modules.inc

COMPATIBLE_MACHINE = "^(iqonios100hd|iqonios300hd|iqonios300hdv2|mediabox|optimussos1|tmnano2t|tmnano|tm2t|tmtwin|tmsingle)$"

SRCDATE = "20170524"

SRC_URI[md5sum] = "096d0cc99a4084d4b8520f6beb047da6"
SRC_URI[sha256sum] = "be93781fab150c5a90eb104a728bfa508636904f056e994f4b0adc3d1a79dd0c"

SRC_URI = "http://en3homeftp.net/release/images/oedrivers/bcmlinuxdvb_7335-${KV}-${SRCDATE}.tar.gz"
