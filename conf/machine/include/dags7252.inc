require conf/machine/include/dags-arm.inc

KERNELVERSION = "3.14.28"

SOC_FAMILY = "bcm7252s"

STB_PLATFORM = "dags7252"

MACHINE_FEATURES += "emmc mmc"

EXTRA_OECONF_append_pn-transtreamproxy = " --enable-ext-pid"
